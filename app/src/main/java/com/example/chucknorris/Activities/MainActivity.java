package com.example.chucknorris.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.jokes.Model.DataManager;
import com.example.jokes.Model.Joke;
import com.example.chucknorris.R;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {




    private Button btnGetJokeByCategory;
    private Spinner spinnerCategories;
    private TextView tvJoke;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetJokeByCategory = findViewById(R.id.btnGetJokeByCategory);
        spinnerCategories = findViewById(R.id.spinnerCategories);
        tvJoke = findViewById(R.id.tvJoke);

        //
        ArrayList<Joke> jokes = DataManager.generateDB();

        // Populate spinner with categories
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.joke_array,
                android.R.layout.simple_spinner_item
        );//change later
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategories.setAdapter(adapter);



        btnGetJokeByCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a joke from selected category
                String selectedCategory = (String) spinnerCategories.getSelectedItem();
                tvJoke.setVisibility(View.VISIBLE);
                tvJoke.setText(getJokeForCategory(selectedCategory));
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


    private String getJokeForCategory(String category) {
        // Create a list to store jokes of the specified category


        return "";
    }

}

