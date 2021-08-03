package com.example.fragmentscommunicationandbackstack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {


    private TextView mTvName, mTvAge, mTvGrade, mTvPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
        getDataFromIntent();
    }


    private void getDataFromIntent(){

        Model model=(Model)getIntent().getSerializableExtra("model");
        mTvName.setText(model.getName());
        mTvAge.setText(model.getAge()+"");
        mTvGrade.setText(model.getGrade());
        mTvPercentage.setText(model.getPercentage());

    }
    private void initViews() {
        mTvAge=findViewById(R.id.tvStudentAge);
        mTvName=findViewById(R.id.tvStudentName);
        mTvGrade=findViewById(R.id.tvStudentGrade);
        mTvPercentage=findViewById(R.id.tvStudentPercentage);

    }


}