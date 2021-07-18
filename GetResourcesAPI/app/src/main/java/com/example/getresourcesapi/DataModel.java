package com.example.getresourcesapi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class DataModel implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("year")
    private int year;

    @SerializedName("color")
    private String color;

    @SerializedName("pantone_value")
    private String pantoneValue;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getPantoneValue() {
        return pantoneValue;
    }
}