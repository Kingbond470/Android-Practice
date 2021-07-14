package com.example.recyclerviewiv;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class RecevierViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvReceiverMessage;

    public RecevierViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvReceiverMessage = itemView.findViewById(R.id.tvReceiverMessage);
    }

    public void setData(ReceiverModel receiverModel) {
        mTvReceiverMessage.setText(receiverModel.getReceiverMessage());

    }
}
