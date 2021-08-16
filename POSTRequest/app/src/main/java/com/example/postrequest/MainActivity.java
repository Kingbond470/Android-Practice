package com.example.postrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etTitle, etPassword, etRequestType;
    private Button btnPostData;
    private  ResponseModel responseModel=new ResponseModel();

    //Progress bar
    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        btnPostData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //progress bar set
                progressBar = new ProgressDialog(v.getContext());
                progressBar.setCancelable(true);
                progressBar.setMessage("Data Sending ...");
                progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressBar.setProgress(0);
                progressBar.setMax(100);
                progressBar.show();

                //reset progress bar status
                progressBarStatus = 0;

                //using thread
                new Thread(new Runnable() {
                    public void run() {
                        while (progressBarStatus < 100) {

                            // process some tasks
                            progressBarStatus = progressBarStatus+20;

                            // your computer is too fast, sleep 1 second
                            try {
                                Thread.sleep(100);
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
                        // ok,  data is sent,
                       // progressBarStatus=100;
                        if (progressBarStatus >= 100) {

                            // sleep 2 seconds, so that you can see the 100%
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            // close the progress bar dialog
                            progressBar.dismiss();
                        }
                    }
                }).start();
                sendData();
            }
        });


    }

    private void sendData() {
        // sending the data to constructor

        String email=etEmail.getText().toString();
        responseModel.setEmail(email);
        String password=etPassword.getText().toString();
        responseModel.setPassword(password);
        String title=etTitle.getText().toString();
        responseModel.setTitle(title);
        String requestType=etRequestType.getText().toString();
        responseModel.setRequestType(requestType);

        ApiService apiService=Network.getRetrofitInstance().create(ApiService.class);
        Call<ResponseModel> call=apiService.sendData(responseModel);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                ResponseModel responseModel=response.body();
                if(response !=null){
                    Intent intent=new Intent(MainActivity.this,RecieveActivity.class);
                    intent.putExtra("email",responseModel.getEmail());
                    intent.putExtra("password",responseModel.getPassword());
                    intent.putExtra("title",responseModel.getTitle());
                    intent.putExtra("requestType", responseModel.getRequestType());
                    startActivity(intent);

                }

            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }

    private void initViews() {
        etEmail=findViewById(R.id.etEmail);
        etTitle=findViewById(R.id.etTitle);
        etPassword=findViewById(R.id.etPassword);
        etRequestType=findViewById(R.id.etRequestType);
        btnPostData=findViewById(R.id.btnPostRequest);
    }
}