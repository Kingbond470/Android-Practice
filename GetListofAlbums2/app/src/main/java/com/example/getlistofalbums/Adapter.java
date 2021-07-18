package com.example.getlistofalbums;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private List<ResponseModel> albumList;
    public Adapter(List<ResponseModel> albumList) {
        this.albumList=albumList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
        ResponseModel responseModel= albumList.get(position);
        holder.setData(responseModel);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public void updataData(List<ResponseModel> albumList){
        this.albumList=albumList;
        notifyDataSetChanged();

    }
}
