package com.example.getresourcesapi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private TextView tvNumber, tvName, tvYear, tvCompany;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String year = intent.getStringExtra("year");
        String company = intent.getStringExtra("company");
        String background_color = intent.getStringExtra("color");
        String userId = intent.getStringExtra("number");

        linearLayout.setBackgroundColor(Color.parseColor(background_color));
        tvName.setText(name);
        tvCompany.setText(company);
        tvYear.setText(year);
        tvNumber.setText(userId);


    }

    private void initViews() {
        linearLayout = findViewById(R.id.linearLayout);
        tvNumber = findViewById(R.id.tvNumber);
        tvName = findViewById(R.id.tvName);
        tvYear = findViewById(R.id.tvYear);
        tvCompany = findViewById(R.id.tvCompany);
    }

}