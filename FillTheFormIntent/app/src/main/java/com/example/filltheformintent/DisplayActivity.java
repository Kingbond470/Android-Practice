package com.example.filltheformintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class DisplayActivity extends AppCompatActivity {
    private ImageButton btnCheck;
    private EditText etOrganizationName,  etCustomerName,  etMobileNumber, etMail,  etAddress,  etManufacturer, etTaxid, etComapnyId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        initViews();
        Intent intent=getIntent();
        String text1 = intent.getStringExtra("edit1");
        etOrganizationName.setText(text1);
        String text2 = intent.getStringExtra("edit2");
        etCustomerName.setText(text2);
        String text3 = intent.getStringExtra("edit3");
        etMobileNumber.setText(text3);
        String text4 = intent.getStringExtra("edit4");
        etMail.setText(text4);
        String text5 = intent.getStringExtra("edit5");
        etAddress.setText(text5);
        String text6 = intent.getStringExtra("edit6");
        etManufacturer.setText(text6);
        String text7 = intent.getStringExtra("edit7");
        etTaxid.setText(text7);
        String text8 = intent.getStringExtra("edit8");
        etComapnyId.setText(text8);

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