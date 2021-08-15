package com.example.cachethegithubresponse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etSearch;
    private Button btnGetData;
    private RecyclerView recyclerView;

    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();

    private Adapter adapter;
    private ArrayList<ResponseDTO> githubList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

// prepare for a progress bar dialog
                progressBar = new ProgressDialog(v.getContext());
                progressBar.setCancelable(true);
                progressBar.setMessage("Data Fetching ...");
                progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressBar.setProgress(0);
                progressBar.setMax(100);
                progressBar.show();

                //reset progress bar status
                progressBarStatus = 0;

                new Thread(new Runnable() {
                    public void run() {
                        while (progressBarStatus < 100) {

                            // process some tasks
                           progressBarStatus = progressBarStatus+10;

                            // your computer is too fast, sleep 1 second
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            // Update the progress bar
                            progressBarHandler.post(new Runnable() {
                                public void run() {
                                    progressBar.setProgress(progressBarStatus);
                                }
                            });
                        }
                        //for(int i=0; i<5; i++) progressBarStatus=progressBarStatus+20;
                        // ok, file is downloaded,
                        progressBarStatus=100;
                        if (progressBarStatus >= 100) {

                            // sleep 2 seconds, so that you can see the 100%
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            // close the progress bar dialog
                            progressBar.dismiss();
                        }
                    }
                }).start();
                setRecyclerView();
                buildData();
            }
        });
    }

    private void buildData() {
        ApiService apiService=Network.retrofitGetInstance().create(ApiService.class);
        Call<ArrayList<ResponseDTO>> call=apiService.getData(etSearch.getText().toString());
        call.enqueue(new Callback<ArrayList<ResponseDTO>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseDTO>> call, Response<ArrayList<ResponseDTO>> response) {
                ArrayList<ResponseDTO> list=response.body();
                githubList.addAll(list);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseDTO>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failure",Toast.LENGTH_SHORT).show();
            }
        });
     }

    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new Adapter(githubList);
        recyclerView.setAdapter(adapter);
    }

    private void initViews() {
        etSearch=findViewById(R.id.etUserName);
        btnGetData=findViewById(R.id.btnGetData);
        recyclerView=findViewById(R.id.recyclerView);
    }
}
