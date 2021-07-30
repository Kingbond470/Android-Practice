package com.example.sendbroadcastwithintheappwithsecurityconsiderations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnSend;
    private LocalBroadcastReceiver localBroadcastReceiver;
    private static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnSend=findViewById(R.id.btnSend);
        registerLocalReciever();
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = {Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_CODE);
                Intent intent = new Intent();
                intent.setAction("mausam.singh");
                intent.putExtra("message","Message from Activity one");
                sendBroadcast(intent,Manifest.permission.CAMERA);
            }
        });
    }

    private void registerLocalReciever() {
        localBroadcastReceiver = new LocalBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter("mausam.singh");
        registerReceiver(localBroadcastReceiver, intentFilter);

    }
}