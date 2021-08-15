package com.example.inshortsnewsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/news")
    Call<ResponseDTO> getData(@Query("category") String category);

}
