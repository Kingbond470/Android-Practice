package com.example.recyclerviewmusicplayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicViewHolder> {
    private ArrayList<Music> musicList=new ArrayList<>();
    private MusicClickListener musicClickListener;

    public MusicAdapter(ArrayList<Music> musicList, MusicClickListener musicClickListener) {
        this.musicList = musicList;
        this.musicClickListener = musicClickListener;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MusicViewHolder(view,musicClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        Music music=musicList.get(position);
        holder.setData(music,musicClickListener);
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }
}
