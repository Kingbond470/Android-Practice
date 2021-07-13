package com.example.articlescrollingwithrecyclerview;

public class Article {
    private int image;
    private String author;
    private String title;

    //constructor

    public Article(int image, String author, String title) {
        this.image = image;
        this.author = author;
        this.title = title;
    }

    //getter methods

    public int getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
