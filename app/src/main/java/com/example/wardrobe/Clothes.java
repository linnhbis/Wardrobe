package com.example.wardrobe;

import android.media.Image;

public class Clothes {

    private String description;
    private String type;
    private String color;
    private Image image;

    public Clothes(String description, String type, String color){
        this.color = color;
        this.description = description;
        this.type = type;
        this.image = null;


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

    public Image getImage() {
        return image;
    }
}
