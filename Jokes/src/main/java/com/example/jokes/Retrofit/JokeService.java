package com.example.jokes.Retrofit;


public class JokeService {

    //Retrofit
    //  private RetrofitService retrofitService = new RetrofitService();
 //   private JokeApi jokeApi = retrofitService.getRetrofit().create(JokeApi.class);

    public interface JokesCallback {
    }
    }
//        void onJokesReceived(List<Joke> jokes);
//
//        void onFailure(Throwable t);
//    }
//
//    public void addJoke(Joke joke,  final JokesCallback callback){
//        Call<Joke> addJokeCall = jokeApi.addJoke(joke);
//        addJokeCall.enqueue(new Callback<Joke>() {
//            @Override
//            public void onResponse(Call<Joke> call, Response<Joke> response) {
//                Joke joke = response.body();
//                if (joke != null) {
//                    List<Joke> jokes = new ArrayList<>();
//                    jokes.add(joke);
//                    callback.onJokesReceived(jokes);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<Joke> call, Throwable t) {
//
//
//            }
//        });
//
//    }
//
//    public void getJokeByCategory(String category, final JokesCallback callback) {
//        Call<String> getCountryDataCall = jokeApi.getJokeByCategory(name);
//        getCountryDataCall.enqueue(new Callback<Joke>() {
//            @Override
//            public void onResponse(Call<Joke> call, Response<Joke> response) {
//                Joke country = response.body();
//                if (country != null) {
//                    List<Joke> countries = new ArrayList<>();
//                    countries.add(country);
//                    callback.onJokesReceived(jokes);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Joke> call, Throwable t) {
//
//            }
//
//        });
//    }






