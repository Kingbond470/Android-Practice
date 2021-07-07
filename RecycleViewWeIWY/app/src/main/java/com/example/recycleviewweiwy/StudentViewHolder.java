package com.example.recycleviewweiwy;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    private TextView mtvName, mtvAge, mtvRollNo;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mtvName=itemView.findViewById(R.id.tvName);
        mtvAge=itemView.findViewById(R.id.tvAge);
        mtvRollNo=itemView.findViewById(R.id.tvRollNo);
    }

    public void setData(Student student){
        mtvName.setText(student.getName());
        mtvAge.setText(student.getAge() +"");
        mtvRollNo.setText(student.getRollNo());
    }

}
