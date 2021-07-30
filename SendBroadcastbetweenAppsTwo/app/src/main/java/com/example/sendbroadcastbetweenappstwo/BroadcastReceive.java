package com.example.sendbroadcastbetweenappstwo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
      //  String value=intent.getStringExtra("data");
        Toast.makeText(context,"Second App",Toast.LENGTH_SHORT).show();
    }
}
