package com.example.jokes.Retrofit;
import com.example.jokes.Model.Joke;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface JokeApi {
    @GET("/joke/{category}")
    Call<Joke> getJokeByCategory(@Path("category") String category);

    @POST("/joke/add")
    Call<Joke> addJoke(@Query("jokeText") String jokeText, @Query("category") String category);


}


