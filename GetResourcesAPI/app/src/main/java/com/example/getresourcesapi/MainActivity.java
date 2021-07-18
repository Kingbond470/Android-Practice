package com.example.getresourcesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber;
    private Button btnSendData;
    private AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDataDialog();
                apiDataSend();
            }
        });
    }

    public void loadDataDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.activity_second, null));
        builder.setCancelable(true);
        alertDialog = builder.create();
        alertDialog.show();
    }


    public void apiDataSend() {
        ApiDataService apiDataService = Network.getInstance().create(ApiDataService.class);
        int number = Integer.parseInt(etNumber.getText().toString());
        apiDataService.getUser(number).enqueue(new Callback<ResponseModel>() {

            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                ResponseModel responseModel = response.body();
                String name = responseModel.getData().getName();
                String year = responseModel.getData().getYear() + "";
                String company = responseModel.getData().getPantoneValue();
                String color = responseModel.getData().getColor();
                intent.putExtra("name", name);
                intent.putExtra("company", company);
                intent.putExtra("number", etNumber.getText().toString());
                intent.putExtra("year", year);
                intent.putExtra("color", color);
                alertDialog.dismiss();
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }

    private void initViews() {
        etNumber = findViewById(R.id.etNumber);
        btnSendData = findViewById(R.id.btnDataSend);

    }
}