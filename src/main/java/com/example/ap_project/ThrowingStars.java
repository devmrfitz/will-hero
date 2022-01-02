package com.example.ap_project;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class ThrowingStars extends Weapon implements Comparable<Weapon>{
    private static final Image image1 = new Image("file:src/main/resources/com/example/ap_project/images/Sword1.png");
    private static final Image image2 = new Image("file:src/main/resources/com/example/ap_project/images/Sword2.png");
    private static final Image image3 = new Image("file:src/main/resources/com/example/ap_project/images/Sword3.png");
    private static final Image[] images = {null, image1, image2, image3};
    private static final int weaponType = 1;

    private ThrowingStars(int level){
        super(level);
    }

    private static final Map<String, ThrowingStars> instances =
            new HashMap<>();

    public static Weapon getInstance(int level) {

        String key = level+ "";
        if (!instances.containsKey(key)) {
            instances.put(key, new ThrowingStars(level));
        }
        return instances.get(key);
    }

    public void attack(){

    }

    public void equip(){

    }

    public void uEquip(){

    }

    public boolean equals(Object obj){
        if (obj instanceof Weapon){
            Weapon a = new ThrowingStars(1);
            return a.equals(obj);
        }
        else{
            return false;
        }
    }

    @Override
    public int compareTo(Weapon o) {
        if (getLevel() == o.getLevel()){
            return 0;
        }
        else if(getLevel() > o.getLevel()){
            return 0;
        }
        else{
            return -1;
        }
    }

    public int getType(){
        return weaponType;
    }

    public Weapon getUpgradedVersion(){
        if (getLevel() >= 3)
            return this;
        String key = (getLevel()+1)+ "";
        if (!instances.containsKey(key)) {
            instances.put(key, new ThrowingStars(getLevel()+1));
        }
        return instances.get(key);
    }

    public Image getImage(){
        return images[getLevel()];
    }
}
