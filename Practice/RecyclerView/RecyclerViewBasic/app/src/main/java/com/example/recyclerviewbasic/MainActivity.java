package com.example.recyclerviewbasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<Data> dataList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecyclerView();
        buildDataList();
    }

    private void buildDataList() {
        for(int i=0; i<10; i++){
            Data data= new Data("Mausam",R.drawable.flower);
            dataList.add(data);
        }
    }

    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new Adapter(dataList);
        recyclerView.setAdapter(adapter);
    }


    private void initViews() {
        recyclerView=findViewById(R.id.recyclerView);
    }
}