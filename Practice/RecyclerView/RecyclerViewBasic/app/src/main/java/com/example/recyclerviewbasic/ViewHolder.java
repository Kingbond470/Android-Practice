package com.example.recyclerviewbasic;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivImage;
    private TextView tvText;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        ivImage=itemView.findViewById(R.id.ivImage);
        tvText=itemView.findViewById(R.id.tvText);
    }
    public void setData(Data data){
        ivImage.setImageResource(data.getImage());
        tvText.setText(data.getName());
    }
}
