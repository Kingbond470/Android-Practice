package com.example.recyclerviewiii;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvName, mTvAge, mTvAddress;
    private ImageView mIvEdit;
    private ItemClickListener itemClickListener;



    public EmployeeViewHolder(@NonNull  View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        initData(itemView);
        this.itemClickListener=itemClickListener;
    }

    private void initData(View itemView) {
        mTvAddress=itemView.findViewById(R.id.tvAddress);
        mTvAge=itemView.findViewById(R.id.tvAge);
        mTvName=itemView.findViewById(R.id.tvName);
        mIvEdit=itemView.findViewById(R.id.ivEdit);
    }

    public void setData(Employee employee){
        mTvName.setText(employee.getName());
        mTvAge.setText(employee.getAge()+" ");
        mTvAddress.setText(employee.getAddress());
        mIvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(),employee);
            }
        });
    }
}
