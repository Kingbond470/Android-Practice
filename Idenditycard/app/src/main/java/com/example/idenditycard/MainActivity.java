package com.example.idenditycard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Identity> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecyclerView();
        buildList();
    }

    private void buildList() {
        Identity identity1=new Identity(R.drawable.bill_gates,"Microsoft","Age : 64","Profession : Business");
        list.add(identity1);
        Identity identity2=new Identity(R.drawable.jeff_bezos,"Amazon","Age : 56","Profession : Business");
        list.add(identity2);
        Identity identity3=new Identity(R.drawable.prateek_shukla,"Masai School","Age : 31","Profession : Business");
        list.add(identity3);
        Identity identity4=new Identity(R.drawable.bill_gates,"Microsoft","Age : 64","Profession : Business");
        list.add(identity4);
        Identity identity5=new Identity(R.drawable.jeff_bezos,"Amazon","Age : 56","Profession : Business");
        list.add(identity5);
        Identity identity6=new Identity(R.drawable.prateek_shukla,"Masai School","Age : 31","Profession : Business");
        list.add(identity6);
        Identity identity7=new Identity(R.drawable.bill_gates,"Microsoft","Age : 64","Profession : Business");
        list.add(identity7);
        Identity identity8=new Identity(R.drawable.jeff_bezos,"Amazon","Age : 56","Profession : Business");
        list.add(identity8);
        Identity identity9=new Identity(R.drawable.prateek_shukla,"Masai School","Age : 31","Profession : Business");
        list.add(identity9);
        Identity identity10=new Identity(R.drawable.bill_gates,"Microsoft","Age : 64","Profession : Business");
        list.add(identity10);
    }

    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        Adapter adapter=new Adapter(list);
        recyclerView.setAdapter(adapter);
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recycleView);
    }
}