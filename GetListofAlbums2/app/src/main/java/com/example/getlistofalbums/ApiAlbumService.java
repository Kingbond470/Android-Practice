package com.example.getlistofalbums;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public interface ApiAlbumService {

    @GET("/albums")
    Call<List<ResponseModel>> getUser();

}

