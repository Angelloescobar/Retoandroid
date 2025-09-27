package com.example.appchiste;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokeApiService {
    @GET("joke/Any?lang=es")
    Call<JokeResponse> getJoke();
}
