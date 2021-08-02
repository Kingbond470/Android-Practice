package com.example.notifyadapter;

public class ModelClass {

    private String text;
    private Boolean val;

    public ModelClass(String text, Boolean val) {
        this.text = text;
        this.val = val;
    }

    public String getText() {
        return text;
    }

    public Boolean getVal() {
        return val;
    }

}