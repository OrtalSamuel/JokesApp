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


public class JokeController   {
    static final String BASE_URL = "http://10.0.2.2:8088"; // Base URL for the Flask API
    private CallBack_Joke callBackJoke;
    public interface CallBack_Joke {
        void success(Joke joke); // Callback for successful API response
        void error(String error); // Callback for API error


    }
    public JokeController(CallBack_Joke callBackJoke){
        this.callBackJoke = callBackJoke;
    }
    // Initialize Gson and Retrofit for making API calls
    public void getJokeByCategory(String Category) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        JokeApi jokeAPI = retrofit.create(JokeApi.class);

        Call<Joke> call = jokeAPI.getJokeByCategory(Category);
        call.enqueue(internalOneJokeCallBack);
    }
        private Callback<Joke> internalOneJokeCallBack = new Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {
                if (response.isSuccessful()) {
                    Joke joke = response.body();
                    callBackJoke.success(joke);
                    int x = 0;
                } else {
                    callBackJoke.error("" + response.errorBody());
                    Log.d("pttt", "" + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Joke> call, Throwable t) {
                callBackJoke.error(t.getMessage());
                t.printStackTrace();
            }
        };


        public void addJoke(String jokeText, String category) {
//            Call<Joke> addJokeCall = jokeAPI.addJoke(jokeText, category);
//            addJokeCall.enqueue(new Callback<Joke>() {
//                @Override
//                public void onResponse(Call<Joke> call, Response<Joke> response) {
//                    if (response.isSuccessful()) {
//                        Joke joke = response.body();
//                        if (joke != null) {
//                            callback.success(joke);
//                        }
//                    } else {
//                        callback.error("" + response.errorBody());
//                        Log.d("pttt", "" + response.errorBody());
//                    }
//
//
//                }
//                @Override
//                public void onFailure(Call<Joke> call, Throwable t) {
//                    callback.error(t.getMessage());
//                    t.printStackTrace();
//
//                }
//            });
//
            }
    }
