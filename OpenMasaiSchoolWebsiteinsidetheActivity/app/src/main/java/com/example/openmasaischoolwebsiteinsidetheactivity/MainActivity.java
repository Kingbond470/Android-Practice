package com.example.openmasaischoolwebsiteinsidetheactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnMasai;
    private WebView viewMasai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMasai=findViewById(R.id.btnMasai);
        viewMasai=findViewById(R.id.viweWeb);
        btnMasai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewMasai.getSettings().setJavaScriptEnabled(true);
                viewMasai.loadUrl("https://www.masaischool.com/");
            }
        });
    }
}