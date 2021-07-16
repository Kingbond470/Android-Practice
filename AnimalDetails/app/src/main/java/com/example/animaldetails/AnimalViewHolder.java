package com.example.animaldetails;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivImage;
    private TextView tvAnimalType, tvSound;
    private AnimalInterface animalInterface;

    public AnimalViewHolder(@NonNull  View itemView, AnimalInterface animalInterface) {
        super(itemView);
        initViews(itemView);
        this.animalInterface=animalInterface;
    }

    private void initViews(View itemView) {
        ivImage=itemView.findViewById(R.id.ivImage);
        tvAnimalType=itemView.findViewById(R.id.tvAnimalType);
        tvSound=itemView.findViewById(R.id.tvSound);
    }

    public void setData(Animal animal){
        ivImage.setImageResource(animal.getImage());
        tvAnimalType.setText(animal.getAnimalType());
        tvSound.setText(animal.getSound());
        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animalInterface.onImageClick(getAdapterPosition(),animal);
            }
        });
    }
}
