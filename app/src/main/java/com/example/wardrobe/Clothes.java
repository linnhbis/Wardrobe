package com.example.wardrobe;



public class Clothes {

    private String description;
    private String type;
    private String color;
    private int image_id;
    private int usedtime;

    public Clothes(String description, String type, String color, int image_id) {
        this.color = color;
        this.description = description;
        this.type = type;
        this.image_id = image_id;
        this.usedtime = 0;


    }

    public String getDescription() {
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

    public int getUsedtime(){
        return usedtime;

    }


    public void setUsedtime(int usedtime){
        this.usedtime=usedtime;
    }




}