package com.example.youtubelistapp;

public class Youtube {
    private String animeName;
    private String animeLink;

    public Youtube(String animeName, String animeLink) {
        this.animeName = animeName;
        this.animeLink = animeLink;
    }

    public String getAnimeName() {
        return animeName;
    }

    public String getAnimeLink() {
        return animeLink;
    }
}
