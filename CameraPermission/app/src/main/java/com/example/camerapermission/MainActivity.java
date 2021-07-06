package com.example.camerapermission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnCameraPermission;
    private static final int REQUEST_CODE = 0;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCameraPermission = findViewById(R.id.btnCameraPermission);
        btnCameraPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permission = {Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this, permission, REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            showToast("Camera Permission Granted");
        }
        else if(grantResults[0]==PackageManager.PERMISSION_DENIED && count<1){
            showToast("Permission Denied");
            count++;
            String[] permission1={Manifest.permission.CAMERA};
            ActivityCompat.requestPermissions(MainActivity.this,permission1,REQUEST_CODE);
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                showToast("Permission Granted");
            }
            else if(grantResults[0]==PackageManager.PERMISSION_DENIED){
                showToast("Permission Denied");
            }
        }
    }

    public void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

    }
}