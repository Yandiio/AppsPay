package com.example.paycash;

import com.example.paycash.Models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface    {

    @GET("top-headlines")
    Call<News> getHeadlines(
        @Query("Country") String country,
        @Query("apiKey") String apiKey
    );
}