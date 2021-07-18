package com.example.idenditycardproblemcontinuation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IdentityClickListener{

    private RecyclerView recyclerView;
    private ArrayList<Identity> identityList=new ArrayList<>();
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecyclerView();
        buildList();
    }

    private void buildList() {
            for(int i=0; i<10; i++) {
                Identity identity1 = new Identity("Microsoft", "Age : 64", "Profression : Business", R.drawable.bill_gates);
                identityList.add(identity1);
                Identity identity2 = new Identity("Amazon", "Age : 54", "Profression : Business", R.drawable.bill_gates);
                identityList.add(identity2);
                Identity identity3 = new Identity("Masai School", "Age : 32", "Profression : Business", R.drawable.bill_gates);
                identityList.add(identity3);
            }
    }

    private void setRecyclerView() {
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter=new Adapter(identityList, this);
        recyclerView.setAdapter(adapter);

    }


    private void initViews() {
        recyclerView=findViewById(R.id.recycleView);
    }


    @Override
    public void onClickedItem(int position, Identity identity) {
        String companyName=identity.getCompanyName();
        String age=identity.getAge();
        AlertDialog alertDialog= new AlertDialog.Builder(MainActivity.this)
                .setTitle(companyName)
                .setMessage(age)
                .show();
       // adapter.notifyItemChanged(position);
    }
}