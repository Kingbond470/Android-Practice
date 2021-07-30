package com.example.loadtenanimalsprofile;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivImage;
    private TextView tvName;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }


    private void initViews(View itemView) {
        ivImage=itemView.findViewById(R.id.ivAnimal);
        tvName=itemView.findViewById(R.id.tvName);
    }

    public void setData(Animal animal){
        tvName.setText(animal.getName());
        ivImage.setImageResource(animal.getImageId());
    }
}
