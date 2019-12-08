package com.example.wardrobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Wardrobe {
    List<Clothes> tops;
    List<Clothes> bottoms;
    static List<String> suitableColors = Arrays.asList(
            "whiteblack","blackwhite","whitebrown","brownwhite","whitenavy","navywhite","whitegreen","greenwhite",
            "whitered","redwhite","whitepurple","purplewhite","beigeblack","blackbeige","beigebrown","brownbeige",
            "beigered","redbeige","beigegreen","greenbeige","greybrown","browngrey","greygreen","greengrey",
            "pinkbeige","beigepink","pinkgrey","greypink","pinknavy","navypink","yellowblack","blackyellow",
            "yellowbrown","brownyellow","yellowgrey","greyyellow","yellownavy","navyyellow","orangeblack",
            "blackorange","orangewhite","whiteorange","brownred","redbrown","browngreen","greenbrown",
            "navybeige","beigenavy","navygreen","greennavy","greenblack","blackgreen","readnavy","navyred",
            "redblack","blackred","purplebeige","beigepurple","purplebrown","brownpurple"
    );

    public Wardrobe() {
        tops = new ArrayList<>();
        bottoms = new ArrayList<>();
    }

    public void addNewClothes(Clothes clothes) {
        if (clothes.getType().equalsIgnoreCase("top")) {
            tops.add(clothes);
        } else if (clothes.getType().equalsIgnoreCase("bottom")) {
            bottoms.add(clothes);
        } else {
            System.err.println("Unsupported type of clothes: " + clothes.getType());
        }
    }

    public List<Clothes> chooseClothes() {
        for (Clothes top : tops) {
            for (Clothes bottom : bottoms) {
                if(suitable(top,bottom)){
                    top.setUsedtime(top.getUsedtime()+1);
                    bottom.setUsedtime(bottom.getUsedtime()+1);
                    return Arrays.asList(top,bottom);
                }
            }
        }

        System.out.println("No suitable clothes combination found.");
        return Collections.emptyList();
    }

    private boolean suitable(Clothes top, Clothes bottom){
        String colorCombination = top.getColor().toLowerCase() + bottom.getColor().toLowerCase();
        return suitableColors.contains(colorCombination);
    }

}

