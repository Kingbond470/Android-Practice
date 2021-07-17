package com.example.idenditycard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Identity> identityList;

    public Adapter(ArrayList<Identity> identityList) {
        this.identityList=identityList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
        Identity identity= identityList.get(position);
        holder.setData(identity);
    }

    @Override
    public int getItemCount() {
        return identityList.size();
    }
}
