package com.example.receivenameandagebroadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvName, tvAge;
    private Button btnSend;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReciever localReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager=LocalBroadcastManager.getInstance(this);
        initViews();
        registeLocalReceiver();
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("mausam.singh");
                intent.putExtra("name","Mausam Singh");
                intent.putExtra("age","Age:20");
                // intent.putExtra("age",21);
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    private void registeLocalReceiver() {
        localReciever=new LocalReciever();
        IntentFilter intentFilter=new IntentFilter("mausam.singh");
        localBroadcastManager.registerReceiver(localReciever,intentFilter);
    }

    private void initViews() {
        tvName=findViewById(R.id.tvName);
        tvAge=findViewById(R.id.tvAge);
        btnSend=findViewById(R.id.btnSend);

    }

    private class LocalReciever extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent !=null){
                String name=intent.getStringExtra("name");
                tvName.setText(name);
                String age=intent.getStringExtra("age");
                tvAge.setText(age);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReciever);
    }
}