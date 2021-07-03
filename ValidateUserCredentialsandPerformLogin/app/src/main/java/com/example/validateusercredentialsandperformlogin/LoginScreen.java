package com.example.validateusercredentialsandperformlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin, btnForgotPassword;
    private String validEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        initViews();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateEmail() && passwordLength()) {
                    Intent intent = new Intent(LoginScreen.this, HomeScreen.class);
                    intent.putExtra("mail", etEmail.getText().toString());
                    intent.putExtra("password", etPassword.getText().toString());
                    startActivity(intent);
                    Toast.makeText(LoginScreen.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    protected boolean validateEmail() {
        if (etEmail.getText().toString().length()>1 && etEmail.getText().toString().matches(validEmail)) {
            return true;
        }
        else{
            etEmail.setError("Invalid Email");
        }
        return false;
    }

    protected boolean passwordLength() {
        if (etPassword.getText().toString().trim().length() >= 6) {
            return true;
        }else{
            etPassword.setError("Length should be minimum 6");
        }
        return false;

    }

    protected void initViews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnForgotPassword = findViewById(R.id.btnForgotPassword);
    }
}