package com.example.masaipage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SignUpActivity extends AppCompatActivity {
    private Button btnSignIn, btnSignUp;
    private ImageButton btnBack;
    private EditText etusername, etPassword, etEmail;
    private String validEmail = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initViews();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
        if(isValidUsername() && isValidEmail() && isValidPassword()) {
            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    intent.putExtra("username",etusername.getText().toString());
                    startActivity(intent);
                }
            });
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    protected void initViews() {
        btnSignIn = findViewById(R.id.btnsignup_sign);
        btnSignUp = findViewById(R.id.btnsignup_signup);
        btnBack = findViewById(R.id.btnSignUpBack);
        etusername = findViewById(R.id.etsignupName);
        etEmail=findViewById(R.id.etsignupEmail);
        etPassword = findViewById(R.id.etsignupPassword);

    }

    protected boolean isValidEmail(){
        if(etEmail.getText().toString().length()>1 && etEmail.getText().toString().matches(validEmail)){
            return true;
        }
        else{
            etEmail.setError("Invalid Email");
            return false;
        }
    }
    protected boolean isValidUsername() {
        if (etusername.getText().toString().length() >= 4) {
            return true;
        } else {
            etusername.setError("Invalid Name");
            return false;
        }
    }

    protected boolean isValidPassword() {
        if (etPassword.getText().toString().length() >= 6) {
            return true;
        } else {
            etPassword.setError("password is incorrect");
            return false;
        }
    }
}