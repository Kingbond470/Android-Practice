package com.example.cachethegithubresponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/users/{user}/repos")
    // the variable user is dynamic in nature and users, repos are static

    Call<ArrayList<ResponseDTO>> getData(@Path("user") String user);

}
