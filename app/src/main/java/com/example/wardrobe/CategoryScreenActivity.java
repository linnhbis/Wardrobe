package com.example.wardrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoryScreenActivity extends AppCompatActivity {

    Button buttonpants;
    Button buttonshirt;
    Button buttonjacket;
    Button buttondress;
    Button buttonnewitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_screen);



        buttonpants  = findViewById(R.id. buttonpants);
        buttonpants.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryScreenActivity.this, CategoryScreenActivity.class));

            }


        });

        buttonshirt  = findViewById(R.id. buttonshirt);
        buttonshirt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryScreenActivity.this, CategoryScreenActivity.class));

            }


        });
    }
}

