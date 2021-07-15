package com.example.retrofiti;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText mEtUserId;
    private Button mBtnCallApi;
    private TextView mTvFirstName, mTvLastName, mTvEmail;
    private ImageView mIvAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mEtUserId = findViewById(R.id.etUserId);
        mBtnCallApi = findViewById(R.id.btnCallApi);
        mTvFirstName = findViewById(R.id.tvFirstName);
        mTvLastName = findViewById(R.id.tvLastName);
        mTvEmail = findViewById(R.id.tvEmail);
        mIvAvatar = findViewById(R.id.ivAvatar);
        mBtnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService apiService = Network.getInstance().create(ApiService.class);
                int userId = Integer.parseInt(mEtUserId.getText().toString());

                // making an actual api call
                apiService.getUser(userId).enqueue(new Callback<ResponseModel>() {

                    //on success this will be executed
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        ResponseModel model=response.body();                //getting response from server by converting json into pojo
                        String firstName=model.getData().getFirstName();
                        String lastName=model.getData().getLastName();
                        String email=model.getData().getEmail();
                        mTvFirstName.setText(firstName);
                        mTvLastName.setText(lastName);
                        mTvEmail.setText(email);
                        Glide.with(mIvAvatar).load(model.getData().getAvatar()).into(mIvAvatar);

                    }

                    //if api failed then this will be executed
                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {

                    }
                });
            }
        });
    }
}


// use glide and picahuso image library to load image properly
/*
{
    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
        "avatar": "https://reqres.in/img/faces/2-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
 // the create json object
 JsonObject jsonObject=new JsonObject(name);
 */