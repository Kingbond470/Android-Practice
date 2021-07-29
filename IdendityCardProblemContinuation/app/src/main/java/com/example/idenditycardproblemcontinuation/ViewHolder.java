package com.example.idenditycardproblemcontinuation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivImage;
    private TextView tvCompanyName, tvAge, tvProfression;
    private IdentityClickListener identityClickListener;

    public ViewHolder(@NonNull  View itemView, IdentityClickListener identityClickListener) {
        super(itemView);
        this.identityClickListener=identityClickListener;
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
        tvCompanyName.setText(identity.getCompanyName());
        tvAge.setText(identity.getAge());
        tvProfression.setText(identity.getProfression());
        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                identityClickListener.onClickedItem(getAdapterPosition(),identity);
            }
        });
    }
}
