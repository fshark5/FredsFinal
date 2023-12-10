package com.example.myapplication;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GetDataService {
    //@Headers("X-RapidAPI-Key: cfc28f84b9mshf414f934dc9b9f4p15016ajsn4414cdc0892a")
    @GET("search")
    Call<ApiResponse> getAllHomes(@Header("X-RapidAPI-Key") String apiKey, @Query("location") String location);


}
