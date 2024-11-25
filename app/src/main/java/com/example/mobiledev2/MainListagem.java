package com.example.mobiledev2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainListagem extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
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
