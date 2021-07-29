package com.example.callerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContactPermission extends AppCompatActivity {

    private Button btnPermission;
    private static final int REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_permission);

        btnPermission=findViewById(R.id.btnPermission);

        btnPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] Permissions = {Manifest.permission.READ_CONTACTS};
                ActivityCompat.requestPermissions(ContactPermission.this, Permissions, REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(ContactPermission.this,"Contact Permission Accessed",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(ContactPermission.this,MainActivity.class);
            startActivity(intent);

        }else if(grantResults[0] == PackageManager.PERMISSION_DENIED){
            Toast.makeText(ContactPermission.this,"Contact Permission Denied",Toast.LENGTH_SHORT).show();
        }
    }
}