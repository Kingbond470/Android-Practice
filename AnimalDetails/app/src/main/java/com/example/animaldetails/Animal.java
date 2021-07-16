package com.example.animaldetails;

public class Animal {
    private int Image;
    private String animalType, sound, name;

    public Animal(int image, String animalType, String sound, String name) {
        Image = image;
        this.animalType = animalType;
        this.sound = sound;
        this.name=name;
    }

    public int getImage() {
        return Image;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getSound() {
        return sound;
    }
    public String getName(){
        return name;
    }
}
