package com.example.loadgithubprofilesrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<ResponseDTO> responseList;

    public Adapter(ArrayList<ResponseDTO> responseList){
        this.responseList=responseList;
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
        ResponseDTO responseDTO=responseList.get(position);
        holder.setData(responseDTO);
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }

    public void updateData(ArrayList<ResponseDTO> responseList){
        this.responseList = responseList;
        notifyDataSetChanged();
    }
}
