package com.example.customactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
        protected EditText etUsename;
        protected Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsename=findViewById(R.id.etUsername);
        btnSend=findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, etUsename.getText().toString());
                intent.setType("text/plain");

                Intent sendIntent = Intent.createChooser(intent, "message");
                sendIntent.putExtra(Intent.EXTRA_CHOOSER_TARGETS, intent);
                sendIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intent);
                startActivity(sendIntent);

            }
        });
    }
}