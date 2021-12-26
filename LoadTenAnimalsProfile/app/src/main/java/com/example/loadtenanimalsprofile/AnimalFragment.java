package com.example.loadtenanimalsprofile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class AnimalFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Animal> animalList=new ArrayList<>();


    private void buildList(){
        for(int i=0; i<100; i++){
            Animal animal=new Animal("Kajal",R.drawable.kj1);
            animalList.add(animal);
            Animal animal1=new Animal("Kajal",R.drawable.kj2);
            animalList.add(animal1);
            Animal animal2=new Animal("Kajal",R.drawable.kj3);
            animalList.add(animal2);
            Animal animal3=new Animal("Kajal",R.drawable.kj4);
            animalList.add(animal3);
            Animal animal4=new Animal("Kajal",R.drawable.kj5);
            animalList.add(animal4);

        }
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        buildList();
        setRecylerView();
    }

    private void setRecylerView() {
        AnimalAdapter animalAdapter=new AnimalAdapter(animalList);
        // can not use this keyword bcoz it is non acitivty part
        GridLayoutManager linearLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(animalAdapter);
    }

    private void initViews(View view) {
        recyclerView=view.findViewById(R.id.recyclerView);
    }
}