package com.example.eventlistenersandsaveuistates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected TextView tvText;
    protected EditText etText;
    protected Button btnSumbit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        etText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                int length=etText.length();
                String str=etText.getText().toString();
                if(length>=6){
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvText.setText("ButtonClicked");
            }
        });

    }
    protected void initViews(){
        tvText=findViewById(R.id.tvText);
        etText=findViewById(R.id.etText);
        btnSumbit=findViewById(R.id.btnSubmit);
    }
}