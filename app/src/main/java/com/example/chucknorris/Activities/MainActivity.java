package com.example.chucknorris.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.chucknorris.Activities.AddActivity;
import com.example.chucknorris.Activities.GetActivity;
import com.example.chucknorris.R;

public class MainActivity extends AppCompatActivity {

    private Button btnGetJokeByCategory;
    private Button btnAddJoke;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetJokeByCategory = findViewById(R.id.btnGetJokeByCategory);
        btnAddJoke = findViewById(R.id.btnAddJoke);



        btnGetJokeByCategory.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                // Start the GetActivity
                startActivity(new Intent(MainActivity.this, GetActivity.class));
            }
        });

        // Set click listener for the "Add Joke" button
        btnAddJoke.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                // Start the AddActivity
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });

    }
}
