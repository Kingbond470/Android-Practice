package com.example.broadcastreceivers;

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

    private TextView mTvData;
    private Button mBtnSend;
    private LocalBroadcastManager localBroadcastManager;
    private LocalReciever localReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager=LocalBroadcastManager.getInstance(this);
        mTvData=findViewById(R.id.tvData);
        mBtnSend=findViewById(R.id.tvSend);
        registerLocalReciever();
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // action which we will use for broadcast
                Intent intent=new Intent("com.and03.broadcast");
                intent.putExtra("key","Hello Masai School");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    private void registerLocalReciever(){
        localReciever=new LocalReciever();
        IntentFilter intentFilter=new IntentFilter("com.and03.broadcast");
        localBroadcastManager.registerReceiver(localReciever,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReciever);
    }

    private class LocalReciever extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent !=null){
                String data=intent.getStringExtra("key");
                mTvData.setText(data);
            }
        }
    }
}