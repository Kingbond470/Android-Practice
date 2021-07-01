package com.example.sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
        private EditText mEtMail, mEtcc, mEtContent;
        private Button mBtnSend;
        private String validMail="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidateEmail()){
                    Intent intent=new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_EMAIL,new String[] {mEtMail.getText().toString()});
                    intent.putExtra(Intent.EXTRA_CC, new String[]{mEtcc.getText().toString()});
                    intent.putExtra(Intent.EXTRA_TEXT,mEtContent.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
    protected void initViews(){
        mEtMail=findViewById(R.id.email);
        mEtcc=findViewById(R.id.ccaddress);
        mEtContent=findViewById(R.id.content);
        mBtnSend=findViewById(R.id.send);
    }

    protected boolean ValidateEmail(){
        if(mEtMail.getText().toString().trim().length()>=1 && mEtMail.getText().toString().matches(validMail)){
            return true;
        }
        else{
            mEtMail.setError("Invalid Email");
            return false;
        }
    }
}