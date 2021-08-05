package com.example.dynamicfragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle, tvSubTitle;
    private ImageView ivAvatar;

    public ViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvTitle=itemView.findViewById(R.id.tvTitle);
        tvSubTitle=itemView.findViewById(R.id.tvSubTitle);
        ivAvatar=itemView.findViewById(R.id.ivImage);

    }

    public void setData(ResponseDTO responseDTO){
        tvTitle.setText(responseDTO.getTitle());
        tvSubTitle.setText(responseDTO.getSubTitle());
        Glide.with(ivAvatar).load(responseDTO.getImage()).into(ivAvatar);
    }
}
