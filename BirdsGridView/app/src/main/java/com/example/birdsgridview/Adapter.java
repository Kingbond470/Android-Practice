package com.example.birdsgridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<Bird> birdList=new ArrayList<>();
    private BirdClickListener birdClickListener;

    public Adapter(ArrayList<Bird> birdList, BirdClickListener birdClickListener) {
        this.birdList=birdList;
        this.birdClickListener=birdClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view,birdClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bird bird= birdList.get(position);
        holder.setData(bird);
    }

    @Override
    public int getItemCount() {
        return birdList.size();
    }
}
