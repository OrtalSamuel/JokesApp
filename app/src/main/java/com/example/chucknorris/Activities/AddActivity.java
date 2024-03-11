package com.example.chucknorris.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.chucknorris.Activities.MainActivity;
import com.example.chucknorris.R;
import com.example.jokes.Model.Joke;
import com.example.jokes.Retrofit.JokeController;

public class AddActivity extends AppCompatActivity {
    private Button btnAddJoke;
    private Spinner spinnerCategories;
    private TextView tvJoke;
    private EditText joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnAddJoke = findViewById(R.id.btnAddJoke);
        spinnerCategories = findViewById(R.id.spinnerCategories);
        tvJoke = findViewById(R.id.tvJoke);
        joke = findViewById(R.id.joke);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.joke_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategories.setAdapter(adapter);



        btnAddJoke.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                // Start the GetActivity
                String selectedCategory = spinnerCategories.getSelectedItem().toString();
                Log.d("ss",selectedCategory);
                String jokeText = joke.getText().toString().trim();
                joke.setText("");
                if (selectedCategory.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please select a category", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (jokeText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please write a joke", Toast.LENGTH_SHORT).show();
                    return;
                }
                tvJoke.setVisibility(View.VISIBLE);
                Joke joke_add=new Joke(selectedCategory,jokeText);
                JokeController.CallBack_Joke callBackJoke = new JokeController.CallBack_Joke() {

                    @Override
                    public void success(Joke joke) {
                        tvJoke.setText("Joke added to the system");
                    }

                    @Override
                    public void error(String error) {
                        tvJoke.setText("Error: " + error);
                    }

                };
                new JokeController(callBackJoke).addJoke(joke_add);


            }
        });
        spinnerCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




    }
}