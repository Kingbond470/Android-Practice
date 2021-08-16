package com.example.postrequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/posts")
    Call<ResponseModel> sendData(@Body ResponseModel data);
}
