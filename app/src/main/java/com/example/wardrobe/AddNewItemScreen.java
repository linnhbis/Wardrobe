package com.example.wardrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddNewItemScreen extends AppCompatActivity { //this is where you add the new clothes

    Button savebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item_screen);

        savebutton = findViewById(R.id.save_new_item);

        savebutton = findViewById(R.id.save_new_item);
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(AddNewItemScreen.this, CategoryScreenActivity.class));


            }


        });


    }


}





