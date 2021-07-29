package com.example.callerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    private RecyclerView recyclerView;
    private ContactAdapter contactAdapter;
    private ArrayList<Contact> contactList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecyclerView();
        buildList();

    }

    private void buildList() {
        for(int i=0; i<5; i++){
            Contact contact=new Contact("Mausam","7218558435");
            contactList.add(contact);
            Contact contact1=new Contact("Rohit","9764119103");
            contactList.add(contact1);
            Contact contact3=new Contact("Masai","7218558565");
            contactList.add(contact3);
            Contact contact4=new Contact("Nrupul","9764119103");
            contactList.add(contact4);
            Contact contact5=new Contact("Prateek","7878558435");
            contactList.add(contact5);
            Contact contact6=new Contact("Aman","9064119103");
            contactList.add(contact6);
        }
    }

    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        contactAdapter=new ContactAdapter(contactList,this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(contactAdapter);
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recyclerView);

    }

    @Override
    public void onClick(Contact contact) {
        String phoneNumber = contact.getNumber().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);

    }


}