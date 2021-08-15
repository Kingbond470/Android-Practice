package com.example.inshortsnewsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etSearch;
    private RecyclerView recyclerView;
    private AdapterNews adapterNews;
    private ArrayList<DataDTO> dataList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

       
            etSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (etSearch.getText().toString().trim().length() >= 3) {
                        setRecyclerView();
                        buildData();
                    }
                }
            });


    }

    private void buildData() {
        ApiService apiService=Network.getRetrofitInstance().create(ApiService.class);
        Call<ResponseDTO> call=apiService.getData(etSearch.getText().toString());

        call.enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                ResponseDTO responseDTO=response.body();
                List<DataDTO> dataDTOList=responseDTO.getData();
                dataList.addAll(dataDTOList);
                adapterNews.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failure",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        adapterNews=new AdapterNews(dataList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterNews);
    }

    private void initViews() {
        etSearch=findViewById(R.id.etSearch);
        recyclerView=findViewById(R.id.recyclerView);
    }
}