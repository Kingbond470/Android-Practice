package com.example.recyclerviewiv;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;


public class SenderViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvSendMessage;

    public SenderViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvSendMessage = itemView.findViewById(R.id.tvSenderMessage);
    }

    public void setData(SenderModel senderModel) {
        mTvSendMessage.setText(senderModel.getSenderMessage());

    }

}
