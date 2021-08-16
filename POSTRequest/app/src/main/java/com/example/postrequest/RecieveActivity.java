package com.example.postrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecieveActivity extends AppCompatActivity {

    private TextView tvEmail, tvPassword, tvTitle, tvRequestType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve);
        initViews();

        Intent intent=getIntent();

        if(intent !=null){
            tvEmail.setText(intent.getStringExtra("email"));
            tvPassword.setText(intent.getStringExtra("password"));
            tvTitle.setText(intent.getStringExtra("title"));
            tvRequestType.setText(intent.getStringExtra("requestType"));
        }
    }

    private void initViews() {
        tvEmail=findViewById(R.id.tvEmail);
        tvPassword=findViewById(R.id.tvPassword);
        tvTitle=findViewById(R.id.tvTitle);
        tvRequestType=findViewById(R.id.tvRequestType);
    }
}