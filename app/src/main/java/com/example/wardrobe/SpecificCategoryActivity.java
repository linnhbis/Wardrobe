package com.example.wardrobe;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.Map;

public class SpecificCategoryActivity extends Activity { //this is where you see the clothes of the selected category
  //this is for all the categories
    String category;


    private Clothes getClothesFromJSON(JSONObject json ) throws JSONException{

        String description;
        String type;
        String color;
        int id;


        description = json.getString("description");
        type = json.getString("type");
        color = json.getString("color");
        id = json.getInt("id");

        return new Clothes(description, type , color , id );
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_category);

        Bundle extraContent = getIntent().getExtras();
        category = extraContent.getString("category");

       // clothing = new ClothingCategory();
        SharedPreferences sharedPref = getSharedPreferences(
                "wardrobe_save_data", Context.MODE_PRIVATE);
        Map<String, ?> keys = sharedPref.getAll();

        ListView listview;
        switch(category) {
            case "Outfits":

                listview = (ListView) findViewById(R.id.category_list);

                //String[] values = new String[] { "shirt0", "shirt1","shirt2", "shirt3" };

                final ArrayList<WardrobeItems> list_wardrobeitems = new ArrayList<WardrobeItems>();
                for (int i = 0; i < 4; ++i) {
                    list_wardrobeitems.add(
                            new WardrobeItems(
                                   new Clothes (("Shirt" + i).toString(),
                                           ("type"+i).toString(),
                                           ("color"+i).toString(),
                                           R.drawable.shirt_stock),
                                    new Clothes (("Pants" + i).toString(),
                                            ("type"+i).toString(),
                                            ("color"+i).toString(),
                                            R.drawable.stock_dress),
                                    new Clothes (("Dress" + i).toString(),
                                            ("type"+i).toString(),
                                            ("color"+i).toString(),
                                            R.drawable.jacket_stock),

                                    new Clothes (("Jacket" + i).toString(),
                                            ("type"+i).toString(),
                                            ("color"+i).toString(),
                                            R.drawable.pants_stock)

                            )

                    );
                   // int id = getResources().getIdentifier("jacket_stock.jpg","drawable",getPackageName());
                    //String src =
                }

                SharedPreferences sharedPrefOutfits = getSharedPreferences(
                        "wardrobe_save_outfits", Context.MODE_PRIVATE);
                Map<String, ?> outfitKeys = sharedPrefOutfits.getAll();

                for (Map.Entry<String, ?> entry : outfitKeys.entrySet()) {
                    JSONObject outfit = null;

                    try {
                        outfit = new JSONObject("{\"color\": \"Blue\",\"description\": \"desc\",\"type\":\"hoodie\",\"categ\":\"Shirt\"}");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        outfit = new JSONObject(entry.getValue().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    ArrayList<Clothes> importedOutfit = new ArrayList<>();



                        try {
                            JSONObject json = outfit.getJSONObject("Shirt");
                            Clothes shirt = getClothesFromJSON(json);



                            Clothes dress = getClothesFromJSON(outfit.getJSONObject("Dress"));


                            Clothes jacket = getClothesFromJSON(outfit.getJSONObject("Jacket"));


                            Clothes pants  = getClothesFromJSON(outfit.getJSONObject("Pants"));


                            list_wardrobeitems.add(new WardrobeItems(
                                    shirt, pants, dress, jacket
                            ));

                        } catch (JSONException e) {
                            Log.d("reeeeeeeee", "onCreate: asdfg");
                            e.printStackTrace();
                        }

                }





                final OutfitArrayAdapter outfit_adapter = new OutfitArrayAdapter(this,
                        R.layout.clothing_item_layout, list_wardrobeitems);
                Log.d("dkjafjdsa", "onCreate: " + list_wardrobeitems.size());
                listview.setAdapter(outfit_adapter);

                break;
            case "Shirt":
            case "Dress":
            case "Pants":
            case "Jacket":

                int ImageId = 3;
                switch(category){
                    case "Shirt":
                        ImageId = R.drawable.shirt_stock;
                        break;
                    case "Dress":
                        ImageId = R.drawable.stock_dress;
                        break;
                    case "Jacket":
                        ImageId = R.drawable.jacket_stock;
                        break;
                    case "Pants":
                        ImageId = R.drawable.pants_stock;

                }


                 listview = (ListView) findViewById(R.id.category_list);

                //String[] values = new String[] { "shirt0", "shirt1","shirt2", "shirt3" };

                final ArrayList<Clothes> list = new ArrayList<Clothes>();
                for (int i = 0; i < 4; ++i) {
                    list.add(
                            new Clothes(
                                    ("desc" + i).toString(), //contructing string desc1, desc2...
                                    ("type" + i).toString(),
                                    ("color" + i).toString(),
                                    ImageId
                            )
                    );
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
                    int id = 6;
                    try {
                        description = jayson.getString("description");
                        type = jayson.getString("type");
                        color = jayson.getString("color");
                        categ = jayson.getString("category");
                        id = jayson.getInt("id");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Log.d("thisisatag", "onCreate: " + categ);
                    if (categ.compareTo(category) == 0) {

                        list.add(
                                new Clothes(
                                        description.toString(),
                                        type.toString(),
                                        color.toString(),
                                        id
                                )
                        );
                    }

                }

                final StableArrayAdapter adapter = new StableArrayAdapter(this,
                        R.layout.clothing_item_layout, list);
                listview.setAdapter(adapter);


                //TODO: want to make a more specific description screen when user taps specific list item
                // listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {


        }



    }

    private class StableArrayAdapter extends ArrayAdapter<Clothes> {

        private final Context context;
        private final ArrayList<Clothes> values;



        public StableArrayAdapter(Context context, int textViewResourceId,
                                  ArrayList<Clothes> objects) {
            super(context, textViewResourceId, objects);

            this.context = context;
            this.values = objects;
        }

//

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.clothing_item_layout, parent, false);
            TextView textView1 = (TextView) rowView.findViewById(R.id.jacket_line);
            TextView textView2 = (TextView) rowView.findViewById(R.id.pants_line);
            TextView textView3 = (TextView) rowView.findViewById(R.id.dress_line);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.shirt_icon);
            imageView.setImageResource(values.get(position).getImageId());
            textView1.setText(values.get(position).getColor());
            textView2.setText(values.get(position).getDescription());
            textView3.setText(values.get(position).getType());


            return rowView;
        }

    }


    private class OutfitArrayAdapter extends ArrayAdapter<WardrobeItems> {

        private final Context context;
        private final ArrayList<WardrobeItems> values;



        public OutfitArrayAdapter(Context context, int textViewResourceId,
                                  ArrayList<WardrobeItems> objects) {
            super(context, textViewResourceId, objects);

            this.context = context;
            this.values = objects;
        }

//

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.outfit_creation_category, parent, false);
            TextView textView1 = (TextView) rowView.findViewById(R.id.shirt_line);
            TextView textView2 = (TextView) rowView.findViewById(R.id.dress_line);
            TextView textView3 = (TextView) rowView.findViewById(R.id.jacket_line);
            TextView textView4 = (TextView) rowView.findViewById(R.id.pants_line);
            ImageView imageView1 = (ImageView) rowView.findViewById(R.id.shirt_icon);
            ImageView imageView2 = (ImageView) rowView.findViewById(R.id.dress_icon);
            ImageView imageView3 = (ImageView) rowView.findViewById(R.id.jacket_icon);
            ImageView imageView4 = (ImageView) rowView.findViewById(R.id.pants_icon);


            imageView1.setImageResource(values.get(position).getShirt().getImageId());
            imageView2.setImageResource(values.get(position).getDress().getImageId());
            imageView3.setImageResource(values.get(position).getJacket().getImageId());
            imageView4.setImageResource(values.get(position).getPants().getImageId());

            textView1.setText(values.get(position).getShirt().getDescription());
            textView2.setText(values.get(position).getDress().getDescription());
            textView3.setText(values.get(position).getJacket().getDescription());
            textView4.setText(values.get(position).getPants().getDescription());



            return rowView;
        }

    }



}


