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
    Button addNewScreenButton;
    Button outfitbutton;
    Button create_outfit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {  //this contains buttons to all the categorie as well as a add button
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_screen);


        buttonpants = findViewById(R.id.buttonpants);
        buttonpants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantsIntent = new Intent(CategoryScreenActivity.this, SpecificCategoryActivity.class);
                pantsIntent.putExtra("category", "Pants");
                startActivity(pantsIntent);

            }


        });

        buttonshirt = findViewById(R.id.buttonshirt);
        buttonshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shirtIntent = new Intent(CategoryScreenActivity.this, SpecificCategoryActivity.class);
                shirtIntent.putExtra("category", "Shirt");
                startActivity(shirtIntent);
            }


        });

        buttondress = findViewById(R.id.buttondress);
        buttondress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dressIntent = new Intent(CategoryScreenActivity.this, SpecificCategoryActivity.class);
                dressIntent.putExtra("category", "Dress");
                startActivity(dressIntent);
            }


        });

        buttonjacket = findViewById(R.id.buttonjacket);
        buttonjacket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jacketIntent = new Intent(CategoryScreenActivity.this, SpecificCategoryActivity.class);
                jacketIntent.putExtra("category", "Jacket");
                startActivity(jacketIntent);
            }


        });


        addNewScreenButton = findViewById(R.id.add_new_button);
        addNewScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryScreenActivity.this, AddNewItemScreen.class));


            }


        });

        outfitbutton = findViewById(R.id.custom_outfit_category_button);
        outfitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outfitIntent = new Intent(CategoryScreenActivity.this, SpecificCategoryActivity.class);
                outfitIntent.putExtra("category", "Outfits");
                startActivity(outfitIntent);
            }


        });


        create_outfit_button = findViewById(R.id.add_new_outfit_button);
        create_outfit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryScreenActivity.this, OutfitCreationScreen.class));

            }


        });




    }


}