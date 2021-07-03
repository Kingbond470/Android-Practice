package com.example.validateusercredentialsandperformlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {
    protected TextView tvMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        tvMail=findViewById(R.id.tvEmail);
        Intent intent=getIntent();
        String mail=intent.getStringExtra("mail");
        tvMail.setText(mail);
    }
}