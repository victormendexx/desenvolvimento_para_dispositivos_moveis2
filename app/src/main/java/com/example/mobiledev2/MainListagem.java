package com.example.mobiledev2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainListagem extends AppCompatActivity {
    RecyclerView recyclerView;
    // Button buttonMainActivity = findViewById(R.id.buttonMainActivity);

    @Override
    protected void onCreate(Bundle savedInstanceState){
//        buttonMainActivity.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//
//            startActivity(intent);
//        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listagem);
        // Recicla porque reutiliza definições dinamicamente usando classes
        recyclerView = findViewById(R.id.recyclerViewList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PlanetaDao planetaDao = new PlanetaDao();
        PlanetaAdapterRecyclerView padapterRV = new PlanetaAdapterRecyclerView(
                this,
                R.layout.activity_planet_adapter_recycler_view,
                planetaDao.getAllPlanetas()
        );

        recyclerView.setAdapter(padapterRV);
    }
}
