package com.example.inshortsnewsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ViewHolder extends RecyclerView.ViewHolder {

//    author, content, date, time, title and also image
    private ImageView ivImage;
    private TextView tvTitle, tvContent, tvTime, tvDate, tvAuthor;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        ivImage=itemView.findViewById(R.id.ivImage);
        tvTitle=itemView.findViewById(R.id.tvTitle);
        tvContent=itemView.findViewById(R.id.tvContent);
        tvTime=itemView.findViewById(R.id.tvTime);
        tvDate=itemView.findViewById(R.id.tvDate);
        tvAuthor=itemView.findViewById(R.id.tvAuthor);
    }

    public void setData(DataDTO data){
        tvTitle.setText(data.getTitle());
        tvAuthor.setText(data.getAuthor());
        tvContent.setText(data.getContent());
        tvDate.setText(data.getDate());
        tvTime.setText(data.getTime());
        //ivImage.setImageResource(Integer.parseInt(data.getImageUrl()));     // waiting for glide to work properly
        Glide.with(ivImage).load(data.getImageUrl()).into(ivImage);
    }
}
