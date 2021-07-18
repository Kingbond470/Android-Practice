package com.example.getlistofalbums;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ResponseModel implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("userId")
    private int userId;


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getUserId() {
        return userId;
    }
}