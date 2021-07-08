package com.example.recyclerclickview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {

    private ArrayList<StudentModel> studentList;
    private ItemClickListener itemClickListener;

    public StudentAdapter(ArrayList<StudentModel> studentList,ItemClickListener itemClickListener){
        this.studentList=studentList;
        this.itemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new StudentViewHolder(view, itemClickListener);

    }

    @Override
    public void onBindViewHolder(@NonNull  StudentViewHolder holder, int position) {
        StudentModel studentModel=studentList.get(position);
        holder.setData(studentModel);

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
