package com.example.mobiledev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Taco extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<TacoAlimento> listTacoAlimentos = new ArrayList<>();
    private TacoDatabaseHelper tacoDatabaseHelper;
    private TacoAlimentoAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taco);

        recyclerView = findViewById(R.id.recyclerViewTaco);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tacoDatabaseHelper = new TacoDatabaseHelper(this);

        mostrarDados();

        adapter = new TacoAlimentoAdapter(listTacoAlimentos);
        recyclerView.setAdapter(adapter);

        EditText editTextFiltro = findViewById(R.id.editTextFiltro);

        editTextFiltro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filtrarLista(s.toString());
            }

            @Override
            public  void afterTextChanged(Editable s) {}
        });
    }

    private void filtrarLista(String texto){
        List<TacoAlimento> listaFiltrada = new ArrayList<>();
        for (TacoAlimento alimento : listTacoAlimentos) {
            if (alimento.getNome().toLowerCase().contains(texto.toLowerCase())) {
                listaFiltrada.add(alimento);
            }
        }
        adapter.filtrarLista(listaFiltrada);
    }

    private void mostrarDados() {
        SQLiteDatabase db = tacoDatabaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM alimentos_macros_100g", null);

        if (cursor.moveToFirst()) {
            do {
                String nome = cursor.getString(cursor.getColumnIndexOrThrow("nome_alimento"));
                float caloria = cursor.getFloat(cursor.getColumnIndexOrThrow("enegiakcal"));

                listTacoAlimentos.add(new TacoAlimento(nome, caloria));
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}
