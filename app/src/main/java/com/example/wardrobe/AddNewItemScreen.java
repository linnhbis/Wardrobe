package com.example.wardrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

public class AddNewItemScreen extends AppCompatActivity { //this is where you add the new clothes

    Button savebutton;
    Spinner spinnerColor;
    Spinner spinner;
    EditText description;
    EditText type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item_screen);

        savebutton = findViewById(R.id.save_new_item);
        spinner = findViewById(R.id.category_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.category_array));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinnerColor = findViewById(R.id.color_spinner);
        ArrayAdapter<String> adapterColor = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.color_array));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerColor.setAdapter(adapterColor);

        description = findViewById(R.id.editTextDescription);
        type = findViewById(R.id.editTextType);


        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPref = getSharedPreferences(
                        "wardrobe_save_data", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPref.edit();
                String text = type.getText().toString() + description.getText().toString()
                        + spinnerColor.getSelectedItem().toString() + spinner.getSelectedItem().toString();
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
                    jaysonobject.put("description",description.getText().toString());
                    jaysonobject.put("color",spinnerColor.getSelectedItem().toString());
                    jaysonobject.put("type",type.getText().toString());
                    jaysonobject.put("category",spinner.getSelectedItem().toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                editor.putString(encoded, jaysonobject.toString());
                editor.commit();
                Log.d("0", "onClick: " + spinner.getSelectedItem().toString());
               // editor.clear().commit(); //to clear trash
                finish();



                // startActivity(new Intent(AddNewItemScreen.this, CategoryScreenActivity.class));
            }


        });






    }


}





