package com.example.animaldetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalInterface{

    private RecyclerView recyclerView;
    private ArrayList<Animal> animalList=new ArrayList<>();
    private Adapter adapter;

    //on create activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecycleView();
        buildList();
    }

    // to add details about animal-1 and animal-2
    private void buildList() {
        for(int i=0; i<=5; i++){
            Animal animal=new Animal(R.drawable.kurama,"Western Animal","Meow-Meow","Leopard");
            animalList.add(animal);
        }
        for(int i=0; i<=5; i++){
            Animal animal=new Animal(R.drawable.kuramas_previous,"Animal","Bow-Bow","Dog");
            animalList.add(animal);
        }
    }

    // to set the layout and adapter conversation
    private void setRecycleView() {
        adapter=new Adapter(animalList,this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recycleView);
    }

    @Override
    public void onImageClick(int position, Animal animal) {
        String name=animal.getName();
       Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();
//        Toast toast = Toast.makeText(MainActivity.this,name, Toast.LENGTH_LONG);
//        toast.getView().setBackgroundColor(Color.parseColor("#F6AE2D"));
//        toast.show();
        adapter.notifyItemChanged(position);
    }

    // image click -- name of animal




}