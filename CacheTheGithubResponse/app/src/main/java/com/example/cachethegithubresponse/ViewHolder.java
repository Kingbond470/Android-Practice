package com.example.cachethegithubresponse;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView tvUserId;
    private TextView tvLogin;
    private TextView tvDescription;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvUserId = itemView.findViewById(R.id.tvName);
        tvLogin = itemView.findViewById(R.id.tvLogin);
        tvDescription = itemView.findViewById(R.id.tvDescription);
    }

    public void setData(ResponseDTO responseDTO){
        tvUserId.setText(responseDTO.getName());
        tvLogin.setText(responseDTO.getOwner().getLogin());
        tvDescription.setText(responseDTO.getDescription());
    }


}
