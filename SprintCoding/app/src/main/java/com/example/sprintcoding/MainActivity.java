package com.example.sprintcoding;

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

public class MainActivity extends AppCompatActivity {

    private EditText etMail, etPassword;
    private CheckBox checkBoxLogin;
    private Button btnLogin;
    private String validMail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


        boolean value = PreferenceHelper.getBooleanFromPrefernce(MainActivity.this, "check");
        if (value) {
            Intent intent = new Intent(MainActivity.this, HomeScreenActivity.class);
            startActivity(intent);
        } else {

            //  Toast.makeText(MainActivity.this,"Please Sign In",Toast.LENGTH_SHORT).show();

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isEmailValid() && isPasswordValid()) {
                        Intent intent = new Intent(MainActivity.this, HomeScreenActivity.class);
                        PreferenceHelper.writeEmailToPrefernce(MainActivity.this, "email", etMail.getText().toString());
                        PreferenceHelper.writePasswordToPrefernce(MainActivity.this, "password", etPassword.getText().toString());
                        startActivity(intent);
                    }
                }
            });

        }


        checkBoxLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    PreferenceHelper.writeBooleanToPrefernce(MainActivity.this, "check", true);
                    PreferenceHelper.writeEmailToPrefernce(MainActivity.this, "email", etMail.getText().toString());
                    PreferenceHelper.writePasswordToPrefernce(MainActivity.this, "password", etPassword.getText().toString());
                } else if (!buttonView.isChecked()) {
                    PreferenceHelper.writeBooleanToPrefernce(MainActivity.this, "check", false);
                }
            }
        });


    }


    private boolean isEmailValid() {
        if (etMail.getText().toString().matches(validMail)) {
            return true;
        } else {
            etMail.setError("InValid Email");
        }
        return false;
    }

    private boolean isPasswordValid() {
        if (etPassword.getText().toString().trim().length() >= 6) return true;
        else {
            etPassword.setError("Password is very short");
            return false;
        }
    }

    private void initViews() {
        etMail = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPassword);
        checkBoxLogin = findViewById(R.id.checkBoxLogin);
        btnLogin = findViewById(R.id.btnLogin);
    }
}