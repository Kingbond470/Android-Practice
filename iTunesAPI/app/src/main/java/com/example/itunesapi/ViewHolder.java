package com.example.itunesapi;

import android.media.Image;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

public class ViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivTrackImage;
    private TextView tvArtitstName, tvTrackName;
    public Button btnPause, btnPlay, btnDelete;



    public ViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        ivTrackImage=itemView.findViewById(R.id.ivTrackImage);
        tvArtitstName=itemView.findViewById(R.id.tvArtitstName);
        tvTrackName=itemView.findViewById(R.id.tvTrackName);

        btnPause=itemView.findViewById(R.id.btnPause);
        btnPlay=itemView.findViewById(R.id.btnPlay);
        btnDelete=itemView.findViewById(R.id.btnDelete);
    }

    public void setData(ResultsDTO responseDTO){
        Glide.with(ivTrackImage).load(responseDTO.getArtworkUrl100()).into(ivTrackImage);
        tvArtitstName.setText(responseDTO.getArtistName());
        tvTrackName.setText(responseDTO.getTrackName());

    }
}
