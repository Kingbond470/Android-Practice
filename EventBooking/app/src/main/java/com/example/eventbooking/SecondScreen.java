package com.example.eventbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {

//    <!-- In the second screen the user will see
//    the FirstName, LastName and EmailAddress entered by the user
//    in first screen (should be pre filled using shared preference) and
//    also fields to enter the NoOfSeats and DateOfShow and
//    a button to preview all the details in the third screen -->

    private TextView tvSFirstName, tvSLastName, tvSEmailAddress;
    private EditText etSNoOfSeats, etSDateOfShow;
    private Button btnSPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        initView();
        // showing the previous details

        String first_name = PreferenceHelper.getStringFromPreference(SecondScreen.this, "FirstName");
        String last_name = PreferenceHelper.getStringFromPreference(SecondScreen.this, "LastName");
        String email_address = PreferenceHelper.getStringFromPreference(SecondScreen.this, "EmailAddress");
        tvSFirstName.setText(first_name);
        tvSLastName.setText(last_name);
        tvSEmailAddress.setText(email_address);

        btnSPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondScreen.this, ThirdScreen.class);

                // add details in local storage using shared preference
                PreferenceHelper.writeIntToPreference(SecondScreen.this, "noofseats", Integer.parseInt(etSNoOfSeats.getText().toString()));
                PreferenceHelper.writeStringToPreference(SecondScreen.this, "dateofshow", etSDateOfShow.getText().toString());

                startActivity(intent);
            }
        });
    }


    protected void initView() {
        tvSFirstName = findViewById(R.id.tvSFirstName);
        tvSLastName = findViewById(R.id.tvSLastName);
        tvSEmailAddress = findViewById(R.id.tvSEmailAddress);
        etSNoOfSeats = findViewById(R.id.etSNoOfSeats);
        etSDateOfShow = findViewById(R.id.etSDateOfShow);
        btnSPreview = findViewById(R.id.btnSPreview);
    }
}