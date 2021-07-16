package com.example.animaldetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<AnimalViewHolder> {

    private ArrayList<Animal> animalList=new ArrayList<>();
    private AnimalInterface animalInterface;

    public Adapter(ArrayList<Animal> animalList, AnimalInterface animalInterface) {
        this.animalList=animalList;
        this.animalInterface=animalInterface;
    }


    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new AnimalViewHolder(view, animalInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal= animalList.get(position);
        holder.setData(animal);
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }
}
