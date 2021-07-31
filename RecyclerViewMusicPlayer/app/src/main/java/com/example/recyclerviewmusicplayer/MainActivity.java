package com.example.recyclerviewmusicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MusicClickListener{

    private RecyclerView recyclerView;
    private ArrayList<Music> musicList=new ArrayList<>();
    private MusicAdapter musicAdapter;
    private MusicClickListener musicClickListener;


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
        musicAdapter=new MusicAdapter(musicList,musicClickListener);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(musicAdapter);
    }

    private void buildList() {
        for(int i=0; i<3; i++) {
            Music music = new Music(R.drawable.himawari_uzumaki, 1000, R.raw.letmeloveyou, "Let Me Love You");
            musicList.add(music);
            Music music1 = new Music(R.drawable.itachi_and_sasuke, 800, R.raw.animals, "Animals");
            musicList.add(music1);
            Music music2 = new Music(R.drawable.kakashi, 500, R.raw.inthenameoflove, "In The Name Of Love");
            musicList.add(music2);
            Music music3 = new Music(R.drawable.konohamaru_danawrok, 1000, R.raw.legendneverdie, "Legend Never Die");
            musicList.add(music3);
            Music music4 = new Music(R.drawable.madara_uchiha, 2000, R.raw.lightitup, "Light It Up");
            musicList.add(music4);
            Music music5 = new Music(R.drawable.narutoone, 3000, R.raw.summertime, "Summer Time");
            musicList.add(music5);
            Music music6 = new Music(R.drawable.naruto, 4000, R.raw.wherewerise, "Where we rise");
            musicList.add(music6);
            Music music7 = new Music(R.drawable.sasuke_uchiha_naruto, 590, R.raw.wolves, "Wovles");
            musicList.add(music7);
        }
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recyclerView);
    }



    @Override
    public void delete(Music music) {
       // remove music from arraylist and notify adapter
      //  musicList.remove(music);
    }
}