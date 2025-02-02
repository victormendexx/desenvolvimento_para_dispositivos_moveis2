package com.example.mobiledev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    private String note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPaint = findViewById(R.id.buttonPaint);
        Button buttonPlanet = findViewById(R.id.buttonPlanets);
        Button buttonSqlite = findViewById(R.id.buttonSqlite);
        Button buttonLauncher = findViewById(R.id.buttonLauncher);

        buttonPaint.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Paint.class);

            startActivity(intent);
        });

        buttonPlanet.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainListagem.class);

            startActivity(intent);
        });

        buttonSqlite.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Taco.class);

            startActivity(intent);
        });

        buttonLauncher.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Launcher.class);

            startActivity(intent);
        });


    }
}