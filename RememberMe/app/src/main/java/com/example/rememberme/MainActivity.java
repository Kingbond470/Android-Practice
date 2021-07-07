package com.example.rememberme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private CheckBox btnCheckbox;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        boolean value=PreferenceHelper.getBooleanFromPreference(MainActivity.this,"check");
        if(value){
            Intent intent= new Intent(MainActivity.this,HomeScreenActivity.class);
           // PreferenceHelper.writeToPreference(MainActivity.this,"username",etUsername.getText().toString());
            startActivity(intent);
        }
        else {
            Toast.makeText(MainActivity.this, "Please Sign In", Toast.LENGTH_SHORT).show();

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, HomeScreenActivity.class);
                    PreferenceHelper.writeToPreference(MainActivity.this, "username", etUsername.getText().toString());
                    // isBtnChecked(btnCheckbox);
                    startActivity(intent);
                }
            });

        }

        btnCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    PreferenceHelper.writeBooleanToPreference(MainActivity.this,"check",true);
                    PreferenceHelper.writeToPreference(MainActivity.this, "username", etUsername.getText().toString());

                }
                else if( ! buttonView.isChecked()){
                    PreferenceHelper.writeBooleanToPreference(MainActivity.this,"check",false);
                }
            }
        });

    }


//    protected void isBtnChecked(CheckBox btnCheckbox) {
//        boolean check = btnCheckbox.isChecked();
//        if (check) {
//            // logic to store the username
//
//        } else {
//            PreferenceHelper.writeToPreference(MainActivity.this,"username",etUsername.getText().toString());
//
//        }
//
//    }

        protected void initViews () {
            etUsername = findViewById(R.id.etUsername);
            etPassword = findViewById(R.id.etPassword);
            btnCheckbox = findViewById(R.id.btnCheckBox);
            btnLogin = findViewById(R.id.btnLogin);
        }


    }