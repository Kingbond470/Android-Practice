package com.example.recyclerviewmusicplayer;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MusicViewHolder extends RecyclerView.ViewHolder {
    private MusicClickListener musicClickListener;
    private ImageView ivMusicImage;
    private TextView tvDuration, tvMusicName;
    private Button btnPause, btnPlay, btnDelete;
    private ArrayList<Music> musicList;

    public MusicViewHolder(@NonNull View itemView, MusicClickListener musicClickListener) {
        super(itemView);
        this.musicClickListener=musicClickListener;
        itemViews(itemView);
    }

    private void itemViews(View itemView) {
        ivMusicImage=itemView.findViewById(R.id.ivMusicImage);
        tvDuration=itemView.findViewById(R.id.tvDuration);
        tvMusicName=itemView.findViewById(R.id.tvSongName);
        btnPause=itemView.findViewById(R.id.btnPause);
        btnPlay=itemView.findViewById(R.id.btnPlay);
        btnDelete=itemView.findViewById(R.id.btnDelete);
    }

    public void setData(Music music, MusicClickListener musicClickListener) {
        ivMusicImage.setImageResource(music.getImageId());
        tvMusicName.setText(music.getName());
        tvDuration.setText(music.getDuration() + " ");
        MediaPlayer mediaPlayer = MediaPlayer.create(tvMusicName.getContext(), music.getMusic());


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Remove music logic
             musicClickListener.delete(music);

            }
        });
    }

}
