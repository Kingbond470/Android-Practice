package com.example.dynamicfragments;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("{githubUserName}/{githubUserId}/{raw}/{githubId}/{githubBrokerName}")
    Call<ArrayList<ResponseDTO>> data(@Path("githubUserName") String githubUserName,
                                      @Path("githubUserId") String githubUserId,
                                      @Path("raw") String raw,
                                      @Path("githubId") String githubId,
                                      @Path("githubBrokerName") String githubBrokerName

    );
}
