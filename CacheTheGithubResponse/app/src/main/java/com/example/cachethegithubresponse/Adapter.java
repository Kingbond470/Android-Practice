package com.example.cachethegithubresponse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<ResponseDTO> githubList;

    public Adapter(ArrayList<ResponseDTO> githubList) {
        this.githubList = githubList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
        ResponseDTO responseDTO=githubList.get(position);
        holder.setData(responseDTO);
    }

    @Override
    public int getItemCount() {
        return githubList.size();
    }
}
