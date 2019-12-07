package com.example.wardrobe;

public class Clothes {
    private String type;
    private String name;
    private String color;
    private int usedtime;

    //color=white,black,beige,navy,brown,purple,red,green,pink,grey,yellow,orange

    public void Clothes(String name, String type,String colour){
        this.type=type;
        this.name=name;
        this.color=colour;
        this.usedtime= 0;
    }

    public String getType() {
        return type;
    }

    public String getColor(){
        return color;
    }
    public int getUsedtime(){
        return usedtime;
    }

    public void setUsedtime(int usedtime){
        this.usedtime=usedtime;
    }
}
