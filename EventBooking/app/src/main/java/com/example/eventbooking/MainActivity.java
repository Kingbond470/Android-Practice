package com.example.eventbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etFirstName, etLastName, etEmailAddress, etPhoneNumber;
    private Button btnSecondScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btnSecondScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondScreen.class);

                // to add the details
                PreferenceHelper.writeStringToPreference(MainActivity.this, "FirstName", etFirstName.getText().toString());
                PreferenceHelper.writeStringToPreference(MainActivity.this, "LastName", etLastName.getText().toString());
                PreferenceHelper.writeStringToPreference(MainActivity.this, "EmailAddress", etEmailAddress.getText().toString());
                PreferenceHelper.writeIntToPreference(MainActivity.this, "PhoneNumber", Integer.parseInt(etPhoneNumber.getText().toString()));
                startActivity(intent);
            }
        });
    }


    protected void initViews() {
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmailAddress = findViewById(R.id.etEmailAdderss);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        btnSecondScreen = findViewById(R.id.btnSecondScreen);
    }
}