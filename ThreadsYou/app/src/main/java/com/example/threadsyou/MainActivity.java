package com.example.threadsyou;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button btnTask;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


        btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // workerThread.addTask(taskOne);
                WorkerThread workerThread = new WorkerThread("async", mainThreadHandler);
                workerThread.start();


            }

            Handler mainThreadHandler = new Handler(Looper.getMainLooper()) {
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    int progress = (int) msg.obj;
                    progressBar.setProgress(progress);
                }
            };
        });


    }

    private void initViews() {
        btnTask = findViewById(R.id.btnTaskOne);
        progressBar = findViewById(R.id.progessBar);
    }


}