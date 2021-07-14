package com.example.recyclerviewiv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<BaseModel> baseModelList;

    public ChatAdapter(ArrayList<BaseModel> baseModelList) {
        this.baseModelList = baseModelList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:         //sender inflate
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sender_item_layout, parent, false);
                return new SenderViewHolder(view);
            case 1:
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.receiver_item_layout, parent, false);
                return new RecevierViewHolder(view1);
        }
        return null;
    }

    //to check who is sending or receiving, it will return either 0 or 1
    public int getItemViewType(int position) {

        return baseModelList.get(position).getViewType();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = baseModelList.get(position).getViewType();

        switch (viewType) {
            case 0:
                if (holder instanceof SenderViewHolder) {
                    SenderModel senderModel = (SenderModel) baseModelList.get(position);
                    ((SenderViewHolder) holder).setData(senderModel);
                }
                break;
            case 1:
                if (holder instanceof RecevierViewHolder) {
                    ReceiverModel receiverModel = (ReceiverModel) baseModelList.get(position);
                    ((RecevierViewHolder) holder).setData(receiverModel);
                }
                break;
        }

    }


    @Override
    public int getItemCount() {
        return baseModelList.size();
    }

    public void updateData(ArrayList<BaseModel> baseModelList){
        this.baseModelList=baseModelList;
        notifyDataSetChanged();

    }
}
