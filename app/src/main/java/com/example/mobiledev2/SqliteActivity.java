package com.example.mobiledev2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SqliteActivity extends AppCompatActivity {
    SQLiteDatabase bd;
    // Button buttonMainActivity = findViewById(R.id.buttonMainActivity);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        buttonMainActivity.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//
//            startActivity(intent);
//        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        bd = openOrCreateDatabase("notinhas", MODE_PRIVATE, null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS notas ( id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR(100), texto VARCHAR(1000))");
        ContentValues cv = new ContentValues();
        cv.put("titulo", "Baguga ....");
        bd.insert("notas", null, cv);

        Log.d("SqliteActivity", "Nome inserido: " + cv.getAsString("titulo"));
    }
}
