package com.example.masaipage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
        private TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvUsername=findViewById(R.id.tvHomeUsername);
        Intent intent=getIntent();
        String data=intent.getStringExtra("username");
        tvUsername.setText(data);
    }
}