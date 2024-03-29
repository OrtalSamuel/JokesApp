package com.example.chucknorris.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.chucknorris.R;
import com.example.jokes.Model.Joke;
import com.example.jokes.Retrofit.JokeController;

public class GetActivity extends AppCompatActivity {

    private Button btnGetJokeByCategory;
    private Spinner spinnerCategories;
    private TextView tvJoke;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);

        btnGetJokeByCategory = findViewById(R.id.btnGetJokeByCategory);
        spinnerCategories = findViewById(R.id.spinnerCategories);
        tvJoke = findViewById(R.id.tvJoke);

     //   ArrayList<Joke> jokes = DataManager.generateDB();

        // Populate spinner with categories
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.joke_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategories.setAdapter(adapter);



        btnGetJokeByCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a joke from selected category
                String selectedCategory = (String) spinnerCategories.getSelectedItem();
                tvJoke.setVisibility(View.VISIBLE);
                JokeController.CallBack_Joke callBackJoke = new JokeController.CallBack_Joke() {

                    @Override
                    public void success(Joke joke) {
                        tvJoke.setText(joke.getJoke());
                    }

                    @Override
                    public void error(String error) {
                        tvJoke.setText("Error: " + error);
                    }

                };
                new JokeController(callBackJoke).getJokeByCategory(selectedCategory);
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


}

