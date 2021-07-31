package com.example.youtubelistapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class YoutubeViewHolder extends RecyclerView.ViewHolder {

    private TextView tvAnimeName;
    private Button btnAnimeLink;


    public YoutubeViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvAnimeName=itemView.findViewById(R.id.tvName);
        btnAnimeLink=itemView.findViewById(R.id.btnWatch);
    }

    public void setData(Youtube youtube, ItemClickListener itemClickListener){
        tvAnimeName.setText(youtube.getAnimeName());
        btnAnimeLink.setText(youtube.getAnimeLink());
        btnAnimeLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClickLink(youtube);
            }
        });
    }


}
