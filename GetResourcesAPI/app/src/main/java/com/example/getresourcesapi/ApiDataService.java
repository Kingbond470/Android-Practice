package com.example.getresourcesapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiDataService {

    @GET("/api/unknown/{userId}")
    Call<ResponseModel> getUser(@Path("userId") int userId);
}
