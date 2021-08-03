package com.example.fragmentscommunicationandbackstack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class StudentDetailsActivity extends AppCompatActivity implements CommunicationListener {


    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();

        launchStudentPersonalDetailsFragment();
    }

    private void launchStudentPersonalDetailsFragment(){
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        StudentPersonalDetailsFragment fragment=new StudentPersonalDetailsFragment();
        fragment.setCommunicationListener(this);
        transaction.add(R.id.container,fragment,"personal").commit();
    }

    @Override
    public void launchPerformanceFragment(Bundle bundle) {
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            StudentPerformanceDetailsFragment personalDetailsFragment=new StudentPerformanceDetailsFragment();
            personalDetailsFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.container,personalDetailsFragment,"personalDetailFragment").commit();
    }
}