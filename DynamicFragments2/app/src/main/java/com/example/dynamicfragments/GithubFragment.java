package com.example.dynamicfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GithubFragment extends Fragment {


    private Button btnFetchData;
    private RecyclerView recyclerView;

    Adapter adapter;
    private ArrayList<ResponseDTO> githubList=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_github, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        btnFetchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRecyclerView();
                buildDataList();
            }
        });
    }

    private void buildDataList() {

        ApiService apiSerivce = Network.getInstance().create(ApiService.class);
        Call<ArrayList<ResponseDTO>> call = apiSerivce.data("shivarajp",
                "2cbe00030c04472c9d8ad4b0ec112dbe",
                "raw", "c651391e428182f08d60d59e79073f3fcf79b858", "nobroker");
        call.enqueue(new Callback<ArrayList<ResponseDTO>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseDTO>> call, Response<ArrayList<ResponseDTO>> response) {
                githubList = response.body();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseDTO>> call, Throwable t) {

            }
        });

    }

    private void setRecyclerView() {
        adapter=new Adapter(githubList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private void initViews(View view) {
        btnFetchData=view.findViewById(R.id.btnSend);
        recyclerView=view.findViewById(R.id.recyclerView);

    }
}