package com.example.idenditycard;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivImage;
    private TextView tvCompanyName, tvAge, tvProfression;

    public ViewHolder(@NonNull  View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        ivImage=itemView.findViewById(R.id.ivImage);
        tvCompanyName=itemView.findViewById(R.id.tvCompanyName);
        tvAge=itemView.findViewById(R.id.tvAge);
        tvProfression=itemView.findViewById(R.id.tvProfression);
    }

    public void setData(Identity identity){
        ivImage.setImageResource(identity.getImage());
        tvProfression.setText(identity.getProfression());
        tvAge.setText(identity.getAge());
        tvCompanyName.setText(identity.getCompanyName());
    }
}
