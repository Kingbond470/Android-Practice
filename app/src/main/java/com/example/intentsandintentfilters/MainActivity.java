package com.example.intentsandintentfilters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEtUsername;
    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private String emailValidation="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(isUsernameValid() && isPasswordValid() && isEmailValid()){
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                intent.putExtra("username",mEtUsername.getText().toString());
                startActivity(intent);
               }
            }
        });
    }

    private void initViews(){
        mEtUsername=findViewById(R.id.etUsername);
        mEtEmail=findViewById(R.id.etEmail);
        mEtPassword=findViewById(R.id.etPassword);
        mBtnLogin=findViewById(R.id.btnLogin);
    }
    private boolean isEmailValid(){
        if(mEtEmail.getText().toString().length()>=1 && mEtEmail.getText().toString().matches(emailValidation)){
            return true;
        }else{
            mEtEmail.setError("Invalid email");
            return false;
        }
    }

    private boolean isPasswordValid(){
        if(mEtPassword.getText().toString().length()>=6){
            return true;
        }else{
            mEtPassword.setError("Password length is less than 6 characters");
            return false;
        }
    }

    private boolean isUsernameValid(){
        if(mEtUsername.getText().toString().trim().length()>=4){
            return true;
        }
        else{
            mEtUsername.setError("Username is not valid");
            return false;

        }

    }
}