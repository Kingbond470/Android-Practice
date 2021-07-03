package com.example.customactivityreceive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {
    protected TextView tvUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        tvUsername=findViewById(R.id.tvUsername);

        Intent intent=getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if(action.equals(Intent.ACTION_SEND)){
            if(type.startsWith("text/")){
                String data=intent.getStringExtra(intent.EXTRA_TEXT);
                tvUsername.setText(data);
            }
        }
    }
}