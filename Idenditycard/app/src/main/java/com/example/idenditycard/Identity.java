package com.example.idenditycard;

public class Identity {
    private int image;
    private String companyName, age, profression;

    public Identity(int image, String companyName, String age, String profression) {
        this.image = image;
        this.companyName = companyName;
        this.age = age;
        this.profression = profression;
    }

    public int getImage() {
        return image;
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
}
