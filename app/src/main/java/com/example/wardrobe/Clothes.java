package com.example.wardrobe;

import android.media.Image;

public class Clothes {

    private String description;
    private String type;
    private String color;
    private int image_id;

    public Clothes(String description, String type, String color, int image_id){
        this.color = color;
        this.description = description;
        this.type = type;
        this.image_id = image_id;


    }

    public String getDescription(){
        return description;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public int getImageId() {
        return image_id;
    }
}
