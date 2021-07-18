package com.example.idenditycardproblemcontinuation;

public class Identity {
    private String companyName, age, profression;
    private int image;

    public Identity(String companyName, String age, String profression, int image) {
        this.companyName = companyName;
        this.age = age;
        this.profression = profression;
        this.image = image;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAge() {
        return age;
    }

    public String getProfression() {
        return profression;
    }

    public int getImage() {
        return image;
    }
}

