package com.example.cachethegithubresponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    static Retrofit retrofitGetInstance(){
        return new Retrofit.Builder()
                // base url of API
                .baseUrl("https://api.github.com/")
                // to convert from JSON to POJO and POJO to JSON
                .addConverterFactory(GsonConverterFactory.create())
                // build the data
                .build();
    }
}
