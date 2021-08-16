package com.example.totalapplecount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BuyAppleListener, TotalAppleListener {


    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,new TotalApplesFragment())
                .commit();
    }


    @Override
    public void buyAppleListenerItem(Bundle bundle) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        TotalApplesFragment totalApplesFragment=new TotalApplesFragment();
        totalApplesFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragmentContainerView,totalApplesFragment).commit();
    }

    @Override
    public void totalAppleListenerItem(Bundle bundle) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        BuyApplesFragment buyApplesFragment=new BuyApplesFragment();
        buyApplesFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragmentContainerView,buyApplesFragment).addToBackStack("").commit();
    }
}