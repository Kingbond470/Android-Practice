package com.example.sendbroadcastbetweenappstwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        IntentFilter intentFilter = new IntentFilter("mausam.singh");

        registerReceiver(new BroadCastReceiver(),intentFilter);
    }

    private void initViews() {
        tvText=findViewById(R.id.tvText);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BroadcastReceive broadcastReceive=new BroadcastReceive();
        unregisterReceiver(broadcastReceive);
    }

    public class BroadCastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"Notification from Second App",Toast.LENGTH_SHORT).show();
            String value=intent.getStringExtra("data");
            tvText.setText(value);
        }
    }

}