package com.example.itunesapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private EditText etArtist;
    private Button btnSearch;
    private RecyclerView recyclerView;

    private Adapter adapter;
    private ItemClickListener itemClickListener;
    private ArrayList<ResultsDTO> songList = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    private ResponseDTO responseDTO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        //  setRecyclerView();


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildDataList();
                setRecyclerView();
            }
        });
    }

    private void buildDataList() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        Call<ResponseDTO> call = apiService.getSong(etArtist.getText().toString());
        call.enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                responseDTO = response.body();
//                assert responseDTO != null;
                songList.addAll(responseDTO.getResults());
//                adapter.notifyDataSetChanged();

                //  response = response.body();
                // songList=response.body();

                adapter.updateData(responseDTO);
            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setRecyclerView() {
        adapter = new Adapter(songList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void initViews() {
        etArtist = findViewById(R.id.etSearchArtist);
        btnSearch = findViewById(R.id.btnSearch);
        recyclerView = findViewById(R.id.recyclerView);
    }


    @Override
    public void onItemClick(ViewHolder viewHolder, int position) {
//        ResultsDTO resultsModel = songList.get(position);
//        String url = resultsModel.getPreviewUrl();
//        if (viewHolder.btnPlay.getText().toString().equalsIgnoreCase("Play")) {
//            viewHolder.btnPause.setText("Pause");
//            Uri url2 = Uri.parse(url);
//            try {
//                mediaPlayer = new MediaPlayer();
//                mediaPlayer.setDataSource(this, url2);
//                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//                mediaPlayer.prepare();
//                mediaPlayer.start();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } else {
//            viewHolder.btnPause.setText("Pause");
//            mediaPlayer.pause();
////        }
//        }
    }
}
