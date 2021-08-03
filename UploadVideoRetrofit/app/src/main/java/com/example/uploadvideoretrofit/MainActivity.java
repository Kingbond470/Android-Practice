package com.example.uploadvideoretrofit;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private static int RESULT_LOAD_IMAGE = 1;
    private VideoView mIvGallery;
    private Button mBtnOpenGallery;
    private Button mBtnUploadImage;
    private String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }
    
    private void initViews() {
        mIvGallery = findViewById(R.id.imageView);
        mBtnOpenGallery = findViewById(R.id.btnGallery);
        mBtnUploadImage = findViewById(R.id.btnUpload);
        mBtnOpenGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isPermissionGranted()) {
                    openGallery();

                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                }
            }
        });

        mBtnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImageToApi();
            }
        });
    }

    private void uploadImageToApi(){

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Uploading the Video");
        progressDialog.show();

        ApiService apiService=Network.getInstance().create(ApiService.class);
        File file=new File(imagePath);      //convert image path to file
        RequestBody requestBody=RequestBody.create(MediaType.parse("video/*"),file);
        MultipartBody.Part multiBody=MultipartBody.Part.createFormData("image",file.getName(),requestBody);
        apiService.uploadImage(multiBody,"Emulator Video").enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this,"Failure",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private boolean isPermissionGranted() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }


    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        // startActivityForResult(intent,2);
        launchGallery.launch(intent);

    }

    private ActivityResultLauncher<Intent> launchGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getData() != null) {
                        //sending data to api, convert uri to path of image
//                        Uri selectImageUrl = result.getData().getData();
//
//                        try {
//                            InputStream inputStream = getContentResolver().openInputStream(selectImageUrl);
//                            mIvGallery.setImageBitmap(BitmapFactory.decodeStream(inputStream));
//                           getImagePathFromUri(selectImageUrl);
//                           // getImagePathFromUri(selectImageUrl);
//                            mIvGallery.setVideoURI(selectImageUrl);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
                        Uri selectedVideo=result.getData().getData();
                        mIvGallery.setVideoURI(selectedVideo);
                        mIvGallery.setMediaController(new MediaController(MainActivity.this));
                        getImagePathFromUri(selectedVideo);

                    }
                }
            }
    );
    /*
    1. find path of the iamge
    2. Convert part into flie
    3. Generate multipart body
     */


    //quering the data base adn where is the path of image
    @NotNull
    private Cursor getImagePathFromUri(Uri selectedImage) {
        String[] filePath = {MediaStore.Images.Media.DATA};
        Cursor c = getContentResolver().query(selectedImage, filePath,
                null, null, null);
        c.moveToFirst();
        int columnIndex = c.getColumnIndex(filePath[0]);
        imagePath = c.getString(columnIndex);
        return c;
    }



    //starting the activity and gettting the reuslt in same activity
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            } else {
                Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}