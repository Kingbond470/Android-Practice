package com.example.fragmentstransactionmethods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBntAddA, mBtnRemoveA;
    private Button mBtnRepalceAWithBWithBackStack, mBtnRepalceAWithBWithoutBackStack;
    private Button mBtnAddB, mBtnRemoveB, mBtnReplaceBWithA;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager=getSupportFragmentManager();

    }


    private void initViews() {
        mBntAddA=findViewById(R.id.btnAddA);
        mBtnRemoveA=findViewById(R.id.btnRemoveA);
        mBtnReplaceBWithA=findViewById(R.id.btnReplaceBWithA);
        mBtnRepalceAWithBWithBackStack=findViewById(R.id.btnReplaceAWithBBackStack);
        mBtnRepalceAWithBWithoutBackStack=findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        mBtnAddB=findViewById(R.id.btnAddB);
        mBtnRemoveB=findViewById(R.id.btnRemoveB);

        mBntAddA.setOnClickListener(this);
        mBtnRemoveA.setOnClickListener(this);
        mBtnReplaceBWithA.setOnClickListener(this);
        mBtnRepalceAWithBWithoutBackStack.setOnClickListener(this);
        mBtnRepalceAWithBWithBackStack.setOnClickListener(this);
        mBtnRemoveB.setOnClickListener(this);
        mBtnAddB.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch(id){
            case R.id.btnAddA:
                addA();
                break;
            case R.id.btnAddB:
                addB();
                break;
            case R.id.btnRemoveA:
                removeA();
                break;
            case R.id.btnRemoveB:
                removeB();
                break;
            case R.id.btnReplaceAWithBBackStack:
                replaceAWithBWithBackStack();
                break;
            case R.id.btnReplaceAWithBWithoutBackstack:
                repalceAWithB();
                break;
            case R.id.btnReplaceBWithA:
                replaceBWithA();
                break;



        }



    }

    private void replaceAWithBWithBackStack() {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        FragmentB fragmentB=new FragmentB();
        transaction.replace(R.id.flContainer,fragmentB,"fragment B").addToBackStack("").commit();
    }

    private void removeB() {
        FragmentB fragmentB=(FragmentB)fragmentManager.findFragmentByTag("fragment B");
        if(fragmentB !=null){
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.remove(fragmentB).commit();
        }
    }

    private void removeA() {
        FragmentA fragmentA=(FragmentA)fragmentManager.findFragmentByTag("fragment A");
        if(fragmentA !=null){
            FragmentTransaction transaction=fragmentManager.beginTransaction();
            transaction.remove(fragmentA).commit();
        }
    }

    private void replaceBWithA() {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        FragmentA fragmentA=new FragmentA();
        transaction.replace(R.id.flContainer,fragmentA,"fragment A").commit();
    }

    private void repalceAWithB() {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        FragmentB fragmentB=new FragmentB();
        transaction.replace(R.id.flContainer,fragmentB,"fragment A").commit();
    }

    private void addA(){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        FragmentA fragmentA=new FragmentA();
        transaction.add(R.id.flContainer,fragmentA,"fragment A").commit();
    }

    private void addB(){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        FragmentB fragmentB=new FragmentB();
        transaction.add(R.id.flContainer,fragmentB,"fragment B").commit();
    }
}