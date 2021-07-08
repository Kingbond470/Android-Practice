package com.example.recyclerclickview;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvStudentImg;
    private TextView mTvName, mTvAge, mTvDob, mTvAddress;
    private ItemClickListener itemClickListener;
    private RelativeLayout relativeLayout;
    public StudentViewHolder(@NonNull View itemView, ItemClickListener itemClickListener){
        super(itemView);
        initViews(itemView);
        this.itemClickListener=itemClickListener;
    }

    private void initViews(View itemView) {
        mIvStudentImg=itemView.findViewById(R.id.ivStudentImg);
        mTvAddress=itemView.findViewById(R.id.tvAddress);
        mTvName=itemView.findViewById(R.id.tvName);
        mTvAge=itemView.findViewById(R.id.tvAge);
        mTvDob=itemView.findViewById(R.id.tvDob);
        relativeLayout=itemView.findViewById(R.id.realativeLayout);
    }


    public void setData(StudentModel studentModel){
        mIvStudentImg.setImageResource(studentModel.getImageId());
        mTvName.setText(studentModel.getName());
        mTvAge.setText(studentModel.getAge()+"");
        mTvDob.setText(studentModel.getDob());
        mTvAddress.setText(studentModel.getAddress());
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(studentModel, getAdapterPosition());
            }
        });
    }
}
