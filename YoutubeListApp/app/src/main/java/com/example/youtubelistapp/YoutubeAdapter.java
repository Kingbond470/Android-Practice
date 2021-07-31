package com.example.youtubelistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeViewHolder> {
    private ArrayList<Youtube> youtubeList=new ArrayList<>();
    private ItemClickListener itemClickListener;

    public YoutubeAdapter(ArrayList<Youtube> youtubeList, ItemClickListener itemClickListener) {
        this.youtubeList = youtubeList;
        this.itemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public YoutubeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
       return new YoutubeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeViewHolder holder, int position) {
        Youtube youtube=youtubeList.get(position);
        holder.setData(youtube,itemClickListener);
    }

    @Override
    public int getItemCount() {
        return youtubeList.size();
    }
}
