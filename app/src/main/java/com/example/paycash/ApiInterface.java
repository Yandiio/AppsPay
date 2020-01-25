package com.example.paycash;

import com.example.paycash.Models.News;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface    {

    @GET("top-headlines")
    Call<News> getHeadlines(
        @Query("Country") String country,
        @Query("apiKey") String apiKey
    );

    @GET("everything")
    Call<News> getEverything(
            @Query("v2") String v2,
            @Query("apiKey") String apiKey
    );
}