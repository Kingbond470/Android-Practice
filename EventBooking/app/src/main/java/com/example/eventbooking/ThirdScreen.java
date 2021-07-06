package com.example.eventbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdScreen extends AppCompatActivity {
    private TextView tvTFirstName, tvTLastName, tvTEmailAddress, tvTPhoneNumber, tvTNoofseats, tvTDateofshow;
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_screen);

        initViews();

        String first_name = PreferenceHelper.getStringFromPreference(ThirdScreen.this, "FirstName");
        String last_name = PreferenceHelper.getStringFromPreference(ThirdScreen.this, "LastName");
        String email_address = PreferenceHelper.getStringFromPreference(ThirdScreen.this, "EmailAddress");
        String phone_number = PreferenceHelper.getIntFromPreference(ThirdScreen.this, "PhoneNumber")+"";
        String no_of_seats = PreferenceHelper.getIntFromPreference(ThirdScreen.this, "noofseats")+"";
        String date_of_show = PreferenceHelper.getStringFromPreference(ThirdScreen.this, "dateofshow")+"";
        //Note - textview always takes string as input so make it

        //showing the detail into textview
        tvTFirstName.setText(first_name);
        tvTLastName.setText(last_name);
        tvTEmailAddress.setText(email_address);
        tvTPhoneNumber.setText(phone_number);
        tvTNoofseats.setText(no_of_seats);
        tvTDateofshow.setText(date_of_show);


        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ThirdScreen.this)
                        .setTitle("Event Conformation")
                        .setMessage( "the event is confirmed on "+tvTDateofshow.getText().toString())
                        .show();


            }
        });
    }

    protected void initViews() {
        tvTFirstName = findViewById(R.id.tvTFirstName);
        tvTLastName = findViewById(R.id.tvTLastName);
        tvTEmailAddress = findViewById(R.id.tvTEmailAddress);
        tvTPhoneNumber = findViewById(R.id.tvTPhoneNumber);
        tvTNoofseats = findViewById(R.id.tvTNoOfSeats);
        tvTDateofshow = findViewById(R.id.tvTDateOfShow);
        btnConfirm = findViewById(R.id.btnTConfirm);
    }
}