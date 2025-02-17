package com.example.mobiledev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

// Atividade que engloba os botoes e a área de desenho (view)
public class Paint extends AppCompatActivity {
    Button colorButton;
    Button clearButton;
    SimplePaint simplePaint;

    //Button buttonMainActivity = findViewById(R.id.buttonMainActivity);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        buttonMainActivity.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//
//            startActivity(intent);
//        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        colorButton = findViewById(R.id.paintButton);
        clearButton = findViewById(R.id.clearButton);
        simplePaint = findViewById(R.id.simplePaint);

        colorButton.setOnClickListener(view -> {
            openColorPicker();
        });

        clearButton.setOnClickListener(view -> {
            simplePaint.clearDrawing();
        });
    }

    // Canvas para escolher a cor (vi no github)
    public void openColorPicker(){
        new ColorPickerDialog.Builder(Paint.this)
                .setTitle("ColorPicker Dialog")
                .setPreferenceName("MyColorPickerDialog")
                .setPositiveButton("CONFIRM",
                        new ColorEnvelopeListener() {
                            @Override
                            public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                setColor(envelope);
                            }
                        })
                .setNegativeButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                .attachAlphaSlideBar(true)
                .attachBrightnessSlideBar(true)
                .setBottomSpace(12)
                .show();
    }

    public void setColor(ColorEnvelope envelope){
        simplePaint.myPaint.setColor(envelope.getColor());
        colorButton.setBackgroundColor(envelope.getColor());
    }

}