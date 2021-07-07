package com.example.complexpermissions;

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

    private Button btnRequestPermission;
    private static final int REQUEST_CODE=101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRequestPermission=findViewById(R.id.btnReuqestPermission);
        btnRequestPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions={Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};
                ActivityCompat.requestPermissions(MainActivity.this,permissions,REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults[0]==PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED){
            showToast("Camera and Storage permissions granted.");
        }
        else if(grantResults[0]==PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_DENIED){
            //showToast(" Camera granted , Storage denied");
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,permissions[1])){
                showToast("Camera granted , Storage denied");
            } else{
                showToast("Camera granted , storage denied by selecting do not show again.");
            }
        }
        else if(grantResults[0]==PackageManager.PERMISSION_DENIED && grantResults[1]==PackageManager.PERMISSION_DENIED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0]) && ActivityCompat.shouldShowRequestPermissionRationale(this,permissions[1])){
                showToast("Both the permissions denied.");
            }else{
                showToast("Storage denied by selecting do not show again and camera denied by selecting do not show again");
            }
        }
        else if(grantResults[0]==PackageManager.PERMISSION_DENIED && grantResults[1]==PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,permissions[1])){
                showToast("Storage granted , camera denied");
            }else{
                showToast("Storage granted, camera denied by selecting do not show again.");
            }
        }
    }

    private void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}