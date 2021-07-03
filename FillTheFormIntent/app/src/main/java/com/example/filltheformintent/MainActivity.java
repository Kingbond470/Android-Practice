package com.example.filltheformintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
        private ImageButton btnCheck;
        private EditText etOrganizationName,  etCustomerName,  etMobileNumber, etMail,  etAddress,  etManufacturer, etTaxid, etComapnyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("edit1",etOrganizationName.getText().toString());
                intent.putExtra("edit2",etCustomerName.getText().toString());
                intent.putExtra("edit3",etMobileNumber.getText().toString());
                intent.putExtra("edit4",etMail.getText().toString());
                intent.putExtra("edit5",etAddress.getText().toString());
                intent.putExtra("edit6",etManufacturer.getText().toString());
                intent.putExtra("edit7",etTaxid.getText().toString());
                intent.putExtra("edit8",etComapnyId.getText().toString());
                startActivity(intent);
            }
        });

    }

    protected void initViews(){
        etOrganizationName=findViewById(R.id.etOrganizationName);
        etCustomerName=findViewById(R.id.etCustomerName);
        etMobileNumber=findViewById(R.id.etMobileNumber);
        etMail=findViewById(R.id.etEmail);
        etAddress=findViewById(R.id.etAddress);
        etManufacturer=findViewById(R.id.etManufacturer);
        etTaxid=findViewById(R.id.etTexid);
        etComapnyId=findViewById(R.id.etCompanyid);
        btnCheck=findViewById(R.id.btnCheck);
    }
}