package com.example.cntwleandroidvibrator;

import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
                Toast.makeText(mContext, "short vibration", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_long:
                myVibrator.cancel();
                myVibrator.vibrate(new long[]{100, 100, 100, 1000}, 0);
                Toast.makeText(mContext, "long vibration", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_rhythm:
                myVibrator.cancel();
                myVibrator.vibrate(new long[]{500, 100, 500, 100, 500, 100}, 0);
                Toast.makeText(mContext, "vibration in rhythm", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cancle:
                myVibrator.cancel();
                Toast.makeText(mContext, "cancel vibration", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}