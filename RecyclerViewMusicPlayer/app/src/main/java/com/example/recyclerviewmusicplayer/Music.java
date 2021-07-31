package com.example.recyclerviewmusicplayer;

public class Music {
    private int imageId;
    private int duration, music;
    private String name;

    public Music(int imageId, int duration, int music, String name) {
        this.imageId = imageId;
        this.duration = duration;
        this.music = music;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public int getDuration() {
        return duration;
    }

    public int getMusic() {
        return music;
    }

    public String getName() {
        return name;
    }
}
