package com.example.intentsandintentfilters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
        private TextView mtvUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mtvUsername=findViewById(R.id.tvUsername);
        Intent intent=getIntent();
        String username=intent.getStringExtra("username");
        mtvUsername.setText(username);
    }
}