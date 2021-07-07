package com.example.rememberme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class HomeScreenActivity extends AppCompatActivity {

    private TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        tvUsername=findViewById(R.id.tvUsername);

        String user=PreferenceHelper.getFromPreference(HomeScreenActivity.this,"username");

        tvUsername.setText(user);


    }


}