package com.example.loadgithubprofilesrecyclerview;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/users/{user}/repos")
    Call<ArrayList<ResponseDTO>> getData(@Path("user") String user);
}
