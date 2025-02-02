package com.example.mobiledev2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TacoDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "taco.db";
    private static final int DATABASE_VERSION = 1;
    private Context context;

    public TacoDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        executarSQLDoArquivo(db);

        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        while (cursor.moveToNext()) {
            Log.d("TACO_DEBUG", "Tabela encontrada: " + cursor.getString(0));
        }
        cursor.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    private void executarSQLDoArquivo(SQLiteDatabase db) {
        try {
            InputStream is = context.getAssets().open("taco_converted_sqlite.sql");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null){
                sb.append(line).append("\n");
            }
            reader.close();

            String[] sqlStatements = sb.toString().split(";");

            for (String statement : sqlStatements) {
                String trimmedStatement = statement.trim();
                if (!trimmedStatement.isEmpty()) {
                    db.execSQL(trimmedStatement + ";");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
