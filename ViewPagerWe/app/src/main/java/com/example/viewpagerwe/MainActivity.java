package com.example.viewpagerwe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
       // PagerAdapter pagerAdapter=new PagerAdapter();
        setAdapter();
    }

    private void setAdapter() {
        PagerAdapter pagerAdapter=new PagerAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager.setAdapter(pagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull  TabLayout.Tab tab, int position) {
                tab.setText("Fragment - "+position);
                // can also use switch case to write name of tab layout
            }
        }).attach();
    }


    public void setData(String name){
        this.name=name;
    }

    public String getData(){
        return name;
    }
    private void initViews() {
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
    }
}