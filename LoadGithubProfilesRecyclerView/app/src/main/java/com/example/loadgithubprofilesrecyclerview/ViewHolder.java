package com.example.loadgithubprofilesrecyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName, tvLogin;
    private ImageView ivAvatar;

    public ViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvName=itemView.findViewById(R.id.tvName);
        tvLogin=itemView.findViewById(R.id.tvLogin);
        ivAvatar=itemView.findViewById(R.id.ivAvatar_url);
    }

    public void setData(ResponseDTO responseDTO){
        tvName.setText(responseDTO.getName());
        tvLogin.setText(responseDTO.getOwner().getLogin());
        Glide.with(ivAvatar).load(responseDTO.getOwner().getAvatarUrl()).into(ivAvatar);
    }
}
