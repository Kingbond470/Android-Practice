package com.example.itunesapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<ResultsDTO> songList;
    private ResponseDTO responseDTO;

    public Adapter(ArrayList<ResultsDTO> songList){
        this.songList=songList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        ResultsDTO resultsDTO=songList.get(position);
        holder.setData(resultsDTO);
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public void updateData(ResponseDTO responseDTO) {
        this.responseDTO = responseDTO;
        notifyDataSetChanged();
    }
}
