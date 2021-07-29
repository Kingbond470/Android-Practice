package com.example.callerapp;

public class Contact {
    String name;
    String number;
    public Contact(String name,String number){
        this.name=name;
        this.number=number;
    }
    public String getName(){
        return name;
    }
    public String getNumber(){
        return number;
    }
}
