package com.example.notifyadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickListener {

    private Button button;
    private LinearLayout linearLayout;
    Adapter adapter;
    private ArrayList<ModelClass> list = new ArrayList<>();
    ClickListener clickListener;

    RecyclerView rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setRecyclerView();
        setRecyclerViewData();
    }

    private void setRecyclerViewData() {
        list.add(new ModelClass("Books", false));
        list.add(new ModelClass("Podcasts", false));
        list.add(new ModelClass("News", false));
        list.add(new ModelClass("Business", false));
        list.add(new ModelClass("Entertainment", false));
        list.add(new ModelClass("Sports", false));
        list.add(new ModelClass("Technology", false));
        list.add(new ModelClass("Pronunciation", false));
        list.add(new ModelClass("Grammar", false));
        list.add(new ModelClass("Health", false));
        list.add(new ModelClass("Health", false));
    }

    private void setRecyclerView() {
        adapter = new Adapter(list, clickListener);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(gridLayoutManager);
    }

    private void initView() {
        button = findViewById(R.id.btnBooks);
        linearLayout = findViewById(R.id.linearLayout);
        rcv = findViewById(R.id.recycler_view);
    }

    @Override
    public void onClick(int position, ModelClass model) {

    }
}