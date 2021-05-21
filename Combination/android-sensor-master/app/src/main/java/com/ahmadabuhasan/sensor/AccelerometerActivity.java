package com.ahmadabuhasan.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.hardware.SensorEvent;
import android.hardware.Sensor;

import java.util.EventListener;
import java.util.List;

/**
 * Created by Ahmad Abu Hasan on 4/10/2020.
 */

public class AccelerometerActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView1 = null;
    SensorManager sm = null;
    List list;

    SensorEventListener sel = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] values = sensorEvent.values;
            if (sensorEvent.values[1] < 7) {
                textView1.setText("x: " + values[0] + " m/s²\ny: " + values[1] + " m/s²\nz: " + values[2] + " m/s²");
                getWindow().getDecorView().setBackgroundColor(Color.WHITE);
            } else {
                textView1.setText("x: " + values[0] + " m/s²\ny: " + values[1] + " m/s²\nz: " + values[2] + " m/s²");
                getWindow().getDecorView().setBackgroundColor(Color.RED);
            }
        }
    };

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_accelerometer);
//        setTitle("TYPE_ACCELEROMETER");
//
//        textView1 = findViewById(R.id.textView1);
//        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//
//        list = sm.getSensorList(Sensor.TYPE_ACCELEROMETER); //Type Sensor
//        if (list.size() > 0) {
//            sm.registerListener(sel, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
//        } else {
//            Toast.makeText(getBaseContext(), "Sorry, sensor not available for this device.", Toast.LENGTH_LONG).show();
//        }
//    }

    @Override
    protected void onStop() {
        if (list.size() > 0) {
            sm.unregisterListener(sel);
        }
        super.onStop();
    }

    //    vibration related
    private Button btn_hasVibrator;
    private Button btn_short;
    private Button btn_long;
    private Button btn_rhythm;
    private Button btn_cancle;
    private Vibrator myVibrator;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        setTitle("TYPE_ACCELEROMETER");

        textView1 = findViewById(R.id.textView1);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        list = sm.getSensorList(Sensor.TYPE_ACCELEROMETER); //Type Sensor
        if (list.size() > 0) {
            sm.registerListener(sel, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            Toast.makeText(getBaseContext(), "Sorry, sensor not available for this device.", Toast.LENGTH_LONG).show();
        }

        //获得系统的Vibrator实例:
        myVibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
        mContext = AccelerometerActivity.this;
        bindViews();
    }

    private void bindViews() {
        btn_hasVibrator = (Button) findViewById(R.id.btn_hasVibrator);
        btn_short = (Button) findViewById(R.id.btn_short);
        btn_long = (Button) findViewById(R.id.btn_long);
        btn_rhythm = (Button) findViewById(R.id.btn_rhythm);
        btn_cancle = (Button) findViewById(R.id.btn_cancle);

        btn_hasVibrator.setOnClickListener(this);
        btn_short.setOnClickListener(this);
        btn_long.setOnClickListener(this);
        btn_rhythm.setOnClickListener(this);
        btn_cancle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_hasVibrator:
                Toast.makeText(mContext, myVibrator.hasVibrator() ? "Vibrator Exist" : "Vibrator Not Exist",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_short:
                myVibrator.cancel();
                myVibrator.vibrate(new long[]{100, 200, 100, 200}, 0);
                Toast.makeText(mContext, "Short Vibration", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_long:
                myVibrator.cancel();
                myVibrator.vibrate(new long[]{1000, 5000, 1000, 5000}, 0);
                Toast.makeText(mContext, "Long Vibration", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_rhythm:
                myVibrator.cancel();
                myVibrator.vibrate(new long[]{500, 100, 500, 100, 500, 100}, 0);
                Toast.makeText(mContext, "Vibration in rhythm", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cancle:
                myVibrator.cancel();
                Toast.makeText(mContext, "Cancel vibration", Toast.LENGTH_SHORT).show();
        }
    }
}