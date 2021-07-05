package com.example.masaipage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.VersionInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SignInActivity extends AppCompatActivity {
    private Button btnSignIn, btnSignUp, btnForgot;
    private ImageButton btnBack;
    private EditText etusername, etPassword;
    private String validEmail = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initViews();
        if (isValidUsername() && isValidPassword()) {
            btnSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                    intent.putExtra("username",etusername.getText().toString());
                    startActivity(intent);
                }
            });
        }

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    protected void initViews() {
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnsigin_signup);
        btnForgot = findViewById(R.id.btnForgotPassword);
        btnBack = findViewById(R.id.btnSignInBack);
        etusername = findViewById(R.id.etsigninName);
        etPassword = findViewById(R.id.etsigninPassword);

    }

    protected boolean isValidUsername() {
        if (etusername.getText().toString().trim().length() >= 4) {
            return true;
        } else {
            etusername.setError("Invalid Name");
            return false;
        }
    }

    protected boolean isValidPassword() {
        if (etPassword.getText().toString().trim().length() >= 6) {
            return true;
        } else {
            etPassword.setError("password is incorrect");
            return false;
        }
    }
}