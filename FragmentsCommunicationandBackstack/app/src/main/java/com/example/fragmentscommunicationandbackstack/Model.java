package com.example.fragmentscommunicationandbackstack;

import java.io.Serializable;

public class Model implements Serializable {
    String name;
    String grade;
    int age;
    String percentage;

    public Model(String name, String grade, int age, String percentage) {
        this.name = name;
        this.grade = grade;
        this.age = age;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    public String getPercentage() {
        return percentage;
    }
}
