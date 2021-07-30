package com.example.sendbroadcastwithintheappwithsecurityconsiderations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.widget.TextView;

public class RecieveActivity extends AppCompatActivity {

    TextView tvMessage;
    LocalBroadcastReceiver localBroadcastReceiver;
    private static final int REQUEST_CODE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve);
        tvMessage = findViewById(R.id.tvText);
        String[] permissions = {Manifest.permission.CAMERA};
        ActivityCompat.requestPermissions(RecieveActivity.this, permissions, REQUEST_CODE);
        String data  = getIntent().getStringExtra("message");
        tvMessage.setText(data);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localBroadcastReceiver);
    }
}