package com.example.birdsgridview;

public class Bird {
    private int birdImage;
    private String birdName;

    public Bird(int birdImage, String birdName) {
        this.birdImage = birdImage;
        this.birdName = birdName;
    }

    public int getBirdImage() {
        return birdImage;
    }

    public String getBirdName() {
        return birdName;
    }
}
