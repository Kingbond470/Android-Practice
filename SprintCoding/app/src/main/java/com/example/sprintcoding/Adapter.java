package com.example.sprintcoding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private List<ResponseModel> dataList;
    private ClickListener clickListener;

    public Adapter(List<ResponseModel> dataList, ClickListener clickListener) {
        this.dataList = dataList;
        this.clickListener=clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResponseModel responseModel = dataList.get(position);
        holder.setData(responseModel,clickListener);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void updateData(List<ResponseModel> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }
}
