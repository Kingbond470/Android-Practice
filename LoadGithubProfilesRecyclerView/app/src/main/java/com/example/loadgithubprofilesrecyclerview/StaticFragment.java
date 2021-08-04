package com.example.loadgithubprofilesrecyclerview;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.jetbrains.annotations.NotNull;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StaticFragment extends Fragment {

    private EditText etSearch;
    private Button btnGetData;
    private ArrayList<ResponseDTO> responseList=new ArrayList<>();
    private Adapter adapter;
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_static, container, false);

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDataList();
                setRecyclerView();
            }
        });
    }

    private void setRecyclerView() {
        adapter=new Adapter(responseList);
        GridLayoutManager linearLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void buildDataList() {
        ApiService apiService=Network.getInstance().create(ApiService.class);
        Call<ArrayList<ResponseDTO>> responseListCall=apiService.getData(etSearch.getText().toString());
        responseListCall.enqueue(new Callback<ArrayList<ResponseDTO>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseDTO>> call, Response<ArrayList<ResponseDTO>> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    responseList = response.body();
                    adapter.updateData(responseList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseDTO>> call, Throwable t) {

            }
        });

    }

    private void initViews(View view) {
        etSearch=view.findViewById(R.id.etUsername);
        btnGetData=view.findViewById(R.id.btnGetData);
        recyclerView=view.findViewById(R.id.recyclerView);

    }
}