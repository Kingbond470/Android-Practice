package com.example.recyclerclickview;

public class StudentModel {
    private String name;
    private int age;
    private String address,dob;
    private int imageId;

    public StudentModel(String name, int age, String address, String dob, int imageId) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.dob = dob;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public int getImageId() {
        return imageId;
    }
}
