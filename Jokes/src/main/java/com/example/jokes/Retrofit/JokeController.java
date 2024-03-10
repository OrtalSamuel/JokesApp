package com.example.jokes.Retrofit;

import android.util.Log;

import com.example.jokes.Model.Joke;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;

import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;


public class JokeController  {
    static final String BASE_URL = "http://127.0.0.1:8088/"; // Base URL for the Flask API

    public interface CallBack_Joke {
        void success(Joke joke); // Callback for successful API response
        void error(String error); // Callback for API error


    }
    public JokeController() {

    }

    // Initialize Gson and Retrofit for making API calls
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    JokeApi jokeAPI = retrofit.create(JokeApi.class);


    public void getJokeByCategory(String category, final CallBack_Joke callback) {
        Call<Joke> getJokeByCategoryCall = jokeAPI.getJokeByCategory(category);
        getJokeByCategoryCall.enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {
                if (response.isSuccessful()) {
                    Joke joke = response.body();
                    if (joke != null) {
                        callback.success(joke);
                    }
                } else {
                    callback.error("" + response.errorBody());
                    Log.d("pttt", "" + response.errorBody());
                }


            }

            @Override
            public void onFailure(Call<Joke> call, Throwable t) {
                callback.error(t.getMessage());
                t.printStackTrace();

            }
        });
    }
        public void addJoke(String jokeText, String category, final CallBack_Joke callback) {
            Call<Joke> addJokeCall = jokeAPI.addJoke(jokeText, category);
            addJokeCall.enqueue(new Callback<Joke>() {
                @Override
                public void onResponse(Call<Joke> call, Response<Joke> response) {
                    if (response.isSuccessful()) {
                        Joke joke = response.body();
                        if (joke != null) {
                            callback.success(joke);
                        }
                    } else {
                        callback.error("" + response.errorBody());
                        Log.d("pttt", "" + response.errorBody());
                    }


                }
                @Override
                public void onFailure(Call<Joke> call, Throwable t) {
                    callback.error(t.getMessage());
                    t.printStackTrace();

                }
            });

            }
    }
