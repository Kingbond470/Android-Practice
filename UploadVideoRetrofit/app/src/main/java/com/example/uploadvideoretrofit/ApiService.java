package com.example.uploadvideoretrofit;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {

    @Headers("Authorization:Client-ID d845328a700a0ec")
    @POST("3/upload")
    @Multipart
    Call<ResponseDTO> uploadImage(
            @Part MultipartBody.Part file,
            @Part("title") String title
    );
}
