package com.example.callerapp;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private TextView tvName;
    private LinearLayout linearLayout;
    private CardView cardView;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        tvName=itemView.findViewById(R.id.tvName);
        linearLayout=itemView.findViewById(R.id.liearLayout);
        cardView=itemView.findViewById(R.id.cardViewContact);
    }

    public void setData(Contact contact, ItemClickListener itemClickListener){
        tvName.setText(contact.getName());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClick(contact);
            }
        });
    }

}
