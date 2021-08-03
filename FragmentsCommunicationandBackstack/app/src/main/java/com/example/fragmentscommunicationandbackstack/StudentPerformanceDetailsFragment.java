package com.example.fragmentscommunicationandbackstack;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class StudentPerformanceDetailsFragment extends Fragment {

private EditText mEtgrade, mEtPercentage;
private Button mBtnPreview;
private String name;
private int age;
private CommunicationListener communicationListener;

    public StudentPerformanceDetailsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() !=null){
            name=getArguments().getString("name");
            age=getArguments().getInt("age");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_performance_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtgrade=view.findViewById(R.id.etStudentGrade);
        mEtPercentage=view.findViewById(R.id.etStudentPercentage);
        mBtnPreview=view.findViewById(R.id.btnPreview);
        mBtnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String grade=mEtgrade.getText().toString();
                String percentage=mEtPercentage.getText().toString();
                Model model=new Model(name,grade,age,percentage);
                Intent intent=new Intent(getContext(),PreviewActivity.class);
                intent.putExtra("model",model);
                startActivity(intent);

            }
        });
    }




}