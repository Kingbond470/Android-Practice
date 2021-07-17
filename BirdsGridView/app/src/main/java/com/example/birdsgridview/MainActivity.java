package com.example.birdsgridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BirdClickListener{

    private RecyclerView recyclerView;
private Adapter adapter;
private BirdClickListener birdClickListener;
private ArrayList<Bird> birdList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecycleView();
        buildList();
    }

    private void buildList() {
        Bird chuck=new Bird(R.drawable.chuck,"Chuck");
        Bird crow=new Bird(R.drawable.crow,"Crow");
        Bird eagle=new Bird(R.drawable.eagle,"Eagle");
        Bird red=new Bird(R.drawable.red,"Red");
        for(int i=0; i<100; i++){
            if(i%4==0) birdList.add(red);
            else if(i%4==1) birdList.add(crow);
            else if(i%4==2) birdList.add(eagle);
            else if(i%4==3) birdList.add(chuck);
        }
    }

    private void setRecycleView() {
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4);
        adapter=new Adapter(birdList,birdClickListener);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void initViews() {
        recyclerView=findViewById(R.id.recycleView);
    }

    @Override
    public void onBirdClick(int position, Bird bird) {
        String name=bird.getBirdName();
        Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();
        adapter.notifyItemChanged(position);
    }
}