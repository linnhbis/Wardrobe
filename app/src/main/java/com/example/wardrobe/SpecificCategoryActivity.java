package com.example.wardrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SpecificCategoryActivity extends AppCompatActivity {

   // ClothingCategory clothing ;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_category);

        Bundle extraContent = getIntent().getExtras();
        category = extraContent.getString("category");

       // clothing = new ClothingCategory();
    }
}
