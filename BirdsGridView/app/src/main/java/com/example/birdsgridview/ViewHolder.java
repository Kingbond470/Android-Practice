package com.example.birdsgridview;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivImage;
    private BirdClickListener birdClickListener;

    public ViewHolder(@NonNull  View itemView, BirdClickListener birdClickListener) {
        super(itemView);
        initViews(itemView);
        this.birdClickListener=birdClickListener;
    }

    private void initViews(View itemView) {
        ivImage=itemView.findViewById(R.id.ivImage);
    }

    public void setData(Bird bird){
        ivImage.setImageResource(bird.getBirdImage());
      //  ivImage.setImageResource(animal.getImage());
        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                birdClickListener.onBirdClick(getAdapterPosition(),bird);
              //  animalInterface.onImageClick(getAdapterPosition(),animal);
            }
        });
    }

}
