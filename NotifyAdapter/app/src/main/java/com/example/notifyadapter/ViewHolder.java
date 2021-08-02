package com.example.notifyadapter;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ViewHolder extends RecyclerView.ViewHolder {

    private Button button;
    private LinearLayout linearLayout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        button = itemView.findViewById(R.id.btnBooks);
        linearLayout = itemView.findViewById(R.id.linearLayout);
    }

    public void setData(ModelClass model) {
        final boolean[] val = {true};
        button.setText(model.getText());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(val[0]) {
                    button.setBackgroundColor(Color.parseColor("#0583EA"));
                    button.setTextColor(Color.parseColor("#FFFFFF"));
                    val[0] = false;
                }
                else {
                    button.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    button.setTextColor(Color.parseColor("#0583EA"));
                    val[0] = true;
                }
            }
        });
    }
}