package com.example.recycleviewweiwy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        //build the data for student - building the student
        buildStudentList();
        setRecyclerView();
    }

    private void buildStudentList() {
        //data for adapter
        Student student1 = new Student("Mausam", 19, "EMP123");
        studentList.add(student1);
        Student student2 = new Student("Mausam", 19, "EMP123");
        studentList.add(student1);

        for (int i = 0; i < 13; i++) {
            Student student = new Student("XYZ" + i, 19, "EMP3" + i);
            studentList.add(student);
        }

    }

    //setting the recycle view
    private void setRecyclerView() {
        StudentAdapter studentAdapter = new StudentAdapter(studentList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(studentAdapter);
    }

    // to defined the id from xml
    private void initViews() {
        recyclerView = findViewById(R.id.recycleView);
    }
}