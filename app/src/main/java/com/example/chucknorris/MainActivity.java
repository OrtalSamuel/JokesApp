package com.example.chucknorris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // https://pastebin.com/raw/XQBZJEKS

    private Button btnGetRandomJoke;
    private Button btnGetJokeByCategory;
    private Spinner spinnerCategories;
    private TextView tvJoke;


    private String[] categories = {"Math", "Light", "Strength", "Counting", "Hearing"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetRandomJoke = findViewById(R.id.btnGetRandomJoke);
        btnGetJokeByCategory = findViewById(R.id.btnGetJokeByCategory);
        spinnerCategories = findViewById(R.id.spinnerCategories);
        tvJoke = findViewById(R.id.tvJoke);

        //
        ArrayList<Joke> jokes = DataManager.generateDB();

        // Populate spinner with categories
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategories.setAdapter(adapter);

        btnGetRandomJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a random joke
                tvJoke.setVisibility(View.VISIBLE);
                tvJoke.setText(getRandomJoke(jokes));
            }
        });

        btnGetJokeByCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a joke from selected category
                String selectedCategory = (String) spinnerCategories.getSelectedItem();
                tvJoke.setVisibility(View.VISIBLE);
                tvJoke.setText(getJokeForCategory( jokes,selectedCategory));
            }
        });

        // Set spinner item selection listener
        spinnerCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Hide joke text view when a category is selected
                tvJoke.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    private String getRandomJoke(ArrayList<Joke> jokes) {

        // Generate a random index to select a joke from the array
        Random random = new Random();
        int index = random.nextInt(jokes.size());

        return jokes.get(index).getJoke();
    }
    // Method to get a Chuck Norris joke for a given category
    private String getJokeForCategory(ArrayList<Joke> jokes, String category) {
        // Create a list to store jokes of the specified category
        ArrayList<Joke> categoryJokes = new ArrayList<>();
        // Populate the list with jokes of the specified category
        for (Joke joke : jokes) {
            if (joke.getCategory().equals(category)) {
                categoryJokes.add(joke);
            }
        }

        // Check if there are jokes in the specified category
        if (categoryJokes.isEmpty()) {
            return "No jokes found for the category: " + category;
        }

        // Select a random joke from the list of jokes of the specified category
        Random random = new Random();
        int randomIndex = random.nextInt(categoryJokes.size());
        return categoryJokes.get(randomIndex).getJoke();
    }
}

