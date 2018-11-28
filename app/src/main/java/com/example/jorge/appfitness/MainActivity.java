package com.example.jorge.appfitness;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button planchas;
        Button pasos;
        Button abdominales;

        planchas = (Button)findViewById(R.id.btn1);
        planchas.setOnClickListener(this);
        pasos = (Button) findViewById(R.id.btn3);
        pasos.setOnClickListener(this);
        abdominales = (Button) findViewById(R.id.btn2);
        abdominales.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                Intent planchas = new Intent(MainActivity.this, PlanchasActivity.class);
                startActivity(planchas);
                break;
            case R.id.btn2:
                Intent abdominales = new Intent(MainActivity.this, AbdominalesActivity.class);
                startActivity(abdominales);
                break;
            case R.id.btn3:
                Intent pasos = new Intent(MainActivity.this, PasosActivity.class);
                startActivity(pasos);
                break;
        }
    }
}
