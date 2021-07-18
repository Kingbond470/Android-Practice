package com.example.getlistofalbums;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView tvId, tvTitle;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvId=itemView.findViewById(R.id.tvId);
        tvTitle=itemView.findViewById(R.id.tvTitle);

    }


    public void setData(ResponseModel responseModel) {
        tvId.setText(responseModel.getId()+"");
        tvTitle.setText(responseModel.getTitle());
    }
}
