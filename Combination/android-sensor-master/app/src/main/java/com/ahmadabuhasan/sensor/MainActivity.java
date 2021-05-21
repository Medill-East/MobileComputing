package com.ahmadabuhasan.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_hasVibrator;
    private Button btn_short;
    private Button btn_long;
    private Button btn_rhythm;
    private Button btn_cancle;
    private Vibrator myVibrator;
    private Context mContext;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    public void Accelerometer(View view) {
        Intent i = new Intent(MainActivity.this, AccelerometerActivity.class);
        startActivity(i);
    }

    public void Atemperature(View view) {
        Intent i = new Intent(MainActivity.this, TemperatureActivity.class);
        startActivity(i);
    }

    public void Gravity(View view) {
        Intent i = new Intent(MainActivity.this, GravityActivity.class);
        startActivity(i);
    }

    public void Gyroscope(View view) {
        Intent i = new Intent(MainActivity.this, GyroscopeActivity.class);
        startActivity(i);
    }

    public void Light(View view) {
        Intent i = new Intent(MainActivity.this, LightActivity.class);
        startActivity(i);
    }

    public void Linear(View view) {
        Intent i = new Intent(MainActivity.this, LinearActivity.class);
        startActivity(i);
    }

    public void Magnetic(View view) {
        Intent i = new Intent(MainActivity.this, MagneticActivity.class);
        startActivity(i);
    }

    public void Orientation(View view) {
        Intent i = new Intent(MainActivity.this, OrientationActivity.class);
        startActivity(i);
    }

    public void Pressure(View view) {
        Intent i = new Intent(MainActivity.this, PressureActivity.class);
        startActivity(i);
    }

    public void Proximity(View view) {
        Intent i = new Intent(MainActivity.this, ProximityActivity.class);
        startActivity(i);
    }

    public void Relative(View view) {
        Intent i = new Intent(MainActivity.this, RelativeActivity.class);
        startActivity(i);
    }

    public void Rotation(View view) {
        Intent i = new Intent(MainActivity.this, RotationActivity.class);
        startActivity(i);
    }

    public void Temperature(View view) {
        Intent i = new Intent(MainActivity.this, TempActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            startActivity(new Intent(this, AboutActivity.class));
        } else if (item.getItemId() == R.id.list_sensor) {
            startActivity(new Intent(this, LsensorActivity.class));
        }
        return true;
    }

    // vibration related

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获得系统的Vibrator实例:
        myVibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
        mContext = MainActivity.this;
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