package com.example.jorge.appfitness;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PlanchasActivity extends AppCompatActivity implements SensorEventListener {

    TextView texto;
    TextView text2;
    SensorManager sensorManager;
    private Sensor acelerometro;
    private boolean isvibration = false;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planchas);

        texto = (TextView)findViewById(R.id.texto1);
        text2 = (TextView)findViewById(R.id.text2);
        //conectarse a los sensores
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        vibrator.cancel();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x,y,z;
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];

        if(x > -2 && y > 1){
            text2.setText("");
            text2.append("Vuelve a intentarlo");
            if (isvibration)
                vibrator.cancel();
            vibrator.vibrate(300L);
            //vibrator = true;
        }else{
            text2.setText("");
            text2.append("Muy Bien");
        }

        texto.setText("\n");
        texto.append("\n" + "\n" + "\n" + "Valor de  x : " + x );
        texto.append("\n" + "\n" + "\n" + "Valor de  y : " + y );
        texto.append("\n" + "\n" + "\n" + "Valor de  z : " + z );
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
