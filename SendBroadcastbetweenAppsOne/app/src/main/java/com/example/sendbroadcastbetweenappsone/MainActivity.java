package com.example.sendbroadcastbetweenappsone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent("mausam.singh");
                sendIntent.putExtra("data","Message from First Application");
                sendBroadcast(sendIntent);
            }
        });
    }

    private void initViews() {
        btnSend=findViewById(R.id.btnSend);
    }
}