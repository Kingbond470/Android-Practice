package com.example.retrofitii;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private ArrayList<ResponseModel> postMOdelList;

    public PostAdapter(List<ResponseModel> postModelList){
        this.postMOdelList= (ArrayList<ResponseModel>) postModelList;
    }



    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return  new PostViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull  PostViewHolder holder, int position) {
        ResponseModel responseModel=postMOdelList.get(position);
        holder.setData(responseModel);

    }

    @Override
    public int getItemCount() {
        return postMOdelList.size();
    }
}
