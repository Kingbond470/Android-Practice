package com.example.recycleviewweiwy;

public class Student {
    private String name;
    private int age;
    private String rollNo;

    //constructor
    public Student(String name, int age, String rollNo) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
    }

    //getter method
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRollNo() {
        return rollNo;
    }
}
