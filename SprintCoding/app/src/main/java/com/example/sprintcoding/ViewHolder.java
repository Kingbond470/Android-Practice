package com.example.sprintcoding;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    // date, positive, negative,
    //    hospitalizedCurrently,onVentilatorCurrently,
    //    death, dateChecked
    private TextView tvDate, tvPositive, tvNegative, tvHospitalizedCurrently, tvVentilaorCurrently, tvDeath, tvDateChecked;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvDate = itemView.findViewById(R.id.tvDate);
        tvPositive = itemView.findViewById(R.id.tvPositive);
        tvNegative = itemView.findViewById(R.id.tvNegative);
        tvHospitalizedCurrently = itemView.findViewById(R.id.tvHospitalizedCurrent);
        tvVentilaorCurrently = itemView.findViewById(R.id.tvVentilatorCurrent);
        tvDeath = itemView.findViewById(R.id.tvDeath);
        tvDateChecked = itemView.findViewById(R.id.tvDateChecked);
    }


    public void setData(ResponseModel responseModel) {
        int date=responseModel.getDate();
        String res=Integer.toString(date);
        String value=res.substring(0,4)+"-"+res.substring(4,6)+"-"+res.substring(6,8);
        tvDate.setText(value);
        tvPositive.setText(responseModel.getPositive() + "");
        tvNegative.setText(responseModel.getNegative() + "");
        tvHospitalizedCurrently.setText(responseModel.getHospitalizedCurrently() + "");
        tvVentilaorCurrently.setText(responseModel.getOnVentilatorCurrently() + "");
        tvDeath.setText(responseModel.getDeath() + "");
        String dateCheck=responseModel.getDateChecked();
        String value1=dateCheck.substring(0,4)+"-"+dateCheck.substring(5,7)+dateCheck.substring(7,10);
        tvDateChecked.setText(value1);
    }
}
