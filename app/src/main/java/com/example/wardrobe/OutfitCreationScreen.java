package com.example.wardrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OutfitCreationScreen extends AppCompatActivity {  //this is for creating outfits

    Button save_outfit;

    Spinner shirtSpinner;
    Spinner jacketSpinner;
    Spinner dressSpinner;
    Spinner pantsSpinner;

    ImageView shirtView;
    ImageView jacketView;
    ImageView dressView;
    ImageView pantsView;

    HashMap<String,Clothes> pairs;

    ArrayList<String> shirtArray;
    ArrayList<String> jacketArray;
    ArrayList<String> dressArray ;
    ArrayList<String> pantsArray ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfit_creation_screen);

        save_outfit = findViewById(R.id.save_outfit_button);

         shirtArray = new ArrayList<String>();
         jacketArray = new ArrayList<String>();
        dressArray = new ArrayList<String>();
        pantsArray = new ArrayList<String>();

        shirtSpinner = findViewById(R.id.shirt_spinner);
        jacketSpinner = findViewById(R.id.jacket_spinner);
        dressSpinner = findViewById(R.id.dress_spinner);
        pantsSpinner = findViewById(R.id.pants_spinner);

        shirtView = findViewById(R.id.shirt_image);
        jacketView = findViewById(R.id.jacket_image);
        dressView = findViewById(R.id.dress_image);
        pantsView = findViewById(R.id.pants_image);

        SharedPreferences sharedPref = getSharedPreferences(
                "wardrobe_save_data", Context.MODE_PRIVATE);
        final SharedPreferences sharedPref_outfits = getSharedPreferences(
                "wardrobe_save_outfits", Context.MODE_PRIVATE);
        Map<String, ?> keys = sharedPref.getAll();

         pairs = new HashMap<>();


        for(int i = 0; i < 4; ++i ) {
            pairs.put("Shirt"+i,new Clothes(("desc"+ i ).toString(),("type"+i).toString(),("color"+i).toString(),R.drawable.shirt_stock));
            pairs.put("Jacket"+i,new Clothes(("desc"+ i ).toString(),("type"+i).toString(),("color"+i).toString(),R.drawable.jacket_stock));
            pairs.put("Dress"+i,new Clothes(("desc"+ i ).toString(),("type"+i).toString(),("color"+i).toString(),R.drawable.stock_dress));
            pairs.put("Pants"+i,new Clothes(("desc"+ i ).toString(),("type"+i).toString(),("color"+i).toString(),R.drawable.pants_stock));

            shirtArray.add("Shirt"+i);
            jacketArray.add("Jacket"+i);
            dressArray.add("Dress"+i);
            pantsArray.add("Pants"+i);



        }



        for (Map.Entry<String, ?> entry : keys.entrySet()) {
            Log.d("0", "onCreate:asdf " + entry.getKey());

            JSONObject jayson = null;
            try {
                jayson = new JSONObject("{\"color\": \"Blue\",\"description\": \"desc\",\"type\":\"hoodie\",\"categ\":\"Shirt\"}");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                jayson = new JSONObject(entry.getValue().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String description = "";
            String type = "";
            String color = "";
            String categ = "";
            int ImageId = 0;

            try {
                description = jayson.getString("description");
                type = jayson.getString("type");
                color = jayson.getString("color");
                categ = jayson.getString("category");
                ImageId = jayson.getInt("id");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Clothes clothes = new Clothes(description, type, color,ImageId);

            pairs.put(description,clothes);

            switch(categ) {
                case "Shirt":
                shirtArray.add(description);
                break;
                case "Jacket":
                jacketArray.add(description);
                break;
                case "Dress":
                dressArray.add(description);
                break;
                case "Pants":
                pantsArray.add(description);
                break;
            }





        }

        ArrayAdapter<String> adapterShirt = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,shirtArray );
        adapterShirt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterJacket = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, jacketArray);
        adapterJacket.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterDress = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dressArray);
        adapterDress.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterPants = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, pantsArray);
        adapterPants.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shirtSpinner.setAdapter(adapterShirt);
        jacketSpinner.setAdapter(adapterJacket);
        dressSpinner.setAdapter(adapterDress);
        pantsSpinner.setAdapter(adapterPants);


        shirtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view,int position,long id){


                String text = (String) parentView.getItemAtPosition(position);
                Clothes item = pairs.get(text);
                int imageId = item.getImageId();
                shirtView.setImageResource(imageId);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView){
                shirtView.setImageResource(android.R.drawable.ic_menu_camera);
            }

        });

        jacketSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view,int position,long id){


                String text = (String) parentView.getItemAtPosition(position);
                Clothes item = pairs.get(text);
                int imageId = item.getImageId();
                jacketView.setImageResource(imageId);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView){
                jacketView.setImageResource(android.R.drawable.ic_menu_camera);
            }

        });

        dressSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view,int position,long id){


                String text = (String) parentView.getItemAtPosition(position);
                Clothes item = pairs.get(text);
                int imageId = item.getImageId();
                dressView.setImageResource(imageId);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView){
                dressView.setImageResource(android.R.drawable.ic_menu_camera);
            }

        });

        pantsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view,int position,long id){


                String text = (String) parentView.getItemAtPosition(position);
                Clothes item = pairs.get(text);
                int imageId = item.getImageId();
                pantsView.setImageResource(imageId);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView){
                pantsView.setImageResource(android.R.drawable.ic_menu_camera);
            }

        });

        save_outfit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WardrobeItems newOutfit = new WardrobeItems(
                        pairs.get(shirtSpinner.getSelectedItem().toString()),
                        pairs.get(jacketSpinner.getSelectedItem().toString()),
                        pairs.get(dressSpinner.getSelectedItem().toString()),
                        pairs.get(pantsSpinner.getSelectedItem().toString())


                );
                SharedPreferences.Editor editor = sharedPref_outfits.edit();
                String text = newOutfit.getShirt().getType() + newOutfit.getDress().getDescription()
                        + newOutfit.getJacket().getColor();
                String encoded = "default_string";
                try {
                    MessageDigest digest = MessageDigest.getInstance("SHA-256");
                    byte[] hash = digest.digest(text.getBytes());
                    encoded = hash.toString();

                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }

                JSONObject jaysonobject = new JSONObject();





                try {


                    jaysonobject.put("Shirt", new JSONObject(newOutfit.getShirt().toString()));
                    jaysonobject.put("Dress", new JSONObject(newOutfit.getDress().toString()));
                    jaysonobject.put("Jacket", new JSONObject(newOutfit.getJacket().toString()));
                    jaysonobject.put("Pants", new JSONObject(newOutfit.getPants().toString()));


                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("untag", "onClick:panica ");
                }


                editor.putString(encoded, jaysonobject.toString());
                editor.commit();
                Log.d("tag", "onClick: " + jaysonobject.toString());
               // editor.clear().commit(); //to clear trash

                finish();


            }
        });


    }

}









