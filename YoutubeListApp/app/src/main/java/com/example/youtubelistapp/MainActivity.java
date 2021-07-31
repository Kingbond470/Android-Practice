package com.example.youtubelistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    private ArrayList<Youtube> youtubeList=new ArrayList<>();
    private ItemClickListener itemClickListener;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        YoutubeAdapter youtubeAdapter=new YoutubeAdapter(youtubeList,this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(youtubeAdapter);
    }

    private void buildList() {
        for(int i=0; i<2; i++){
            Youtube youtube=new Youtube("So Far Away","https://youtu.be/FDL1WliZlSU");
            youtubeList.add(youtube);
            Youtube youtube1=new Youtube("Where We Rise","https://youtu.be/scSwX4Wlu58");
            youtubeList.add(youtube1);
            Youtube youtube2=new Youtube("Under The Pressure","https://youtu.be/vOiN9Qbz_4E");
            youtubeList.add(youtube2);
            Youtube youtube3=new Youtube("Your Eyes","https://youtu.be/vSTji9oRAhE");
            youtubeList.add(youtube3);
            Youtube youtube4=new Youtube("Unity","https://youtu.be/4x4cE2eUxJA");
            youtubeList.add(youtube4);
            Youtube youtube5=new Youtube("Rise Up","https://youtu.be/dyWQarTyspc");
            youtubeList.add(youtube5);
            Youtube youtube6=new Youtube("Stronger","https://youtu.be/TqIp7yVjkJg");
            youtubeList.add(youtube6);
            Youtube youtube7=new Youtube("I'm Mess","https://youtu.be/sEPvZ3AlpeI");
            youtubeList.add(youtube7);
            Youtube youtube8=new Youtube("Dance Monkey","https://youtu.be/oye0IHPPeHM");
            youtubeList.add(youtube8);
            Youtube youtube9=new Youtube("God Mode","https://youtu.be/agcNbKVDtQ0");
            youtubeList.add(youtube9);
            Youtube youtube10=new Youtube("Champion","https://youtu.be/Gk1BZ1H3WBg");
            youtubeList.add(youtube10);

        }
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recyclerView);

    }
    @Override
    public void onClickLink(Youtube youtube) {

    }
}