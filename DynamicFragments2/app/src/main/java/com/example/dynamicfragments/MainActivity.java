package com.example.dynamicfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvWatch;
    private FragmentManager fragment;
    private LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        fragment=getSupportFragmentManager();

        tvWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction=fragment.beginTransaction();
                GithubFragment githubFragment=new GithubFragment();
                transaction.replace(R.id.fContainer,githubFragment,"Github Fragment").commit();

            }
        });
    }

    private void initViews() {
        tvWatch=findViewById(R.id.tvWatch);
        linearLayout=findViewById(R.id.fContainer);

    }
}