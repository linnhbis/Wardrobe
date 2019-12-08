package com.example.wardrobe;

public class WardrobeItems {

    private Clothes shirt;
    private Clothes pants;
    private Clothes dress;
    private Clothes jacket;

    public WardrobeItems  (Clothes shirt, Clothes pants, Clothes dress, Clothes jacket){
        this.shirt = shirt;
        this.pants = pants;
        this.dress = dress;
        this.jacket = jacket;
    }

    public Clothes getDress() {
        return dress;
    }

    public Clothes getJacket() {
        return jacket;
    }

    public Clothes getShirt() {
        return shirt;
    }

    public Clothes getPants(){
        return pants;
    }
}
