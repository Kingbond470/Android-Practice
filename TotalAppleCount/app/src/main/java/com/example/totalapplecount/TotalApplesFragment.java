package com.example.totalapplecount;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TotalApplesFragment extends Fragment {

    private EditText etAppleAvailable;
    private TextView tvAppleAvailbale;
    private Button btnGoToBuyApple;
    private TotalAppleListener totalAppleListener;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_apples, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        totalAppleListener= (TotalAppleListener) context;
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // initializing the views
        etAppleAvailable=view.findViewById(R.id.etAppleAvailable);
        tvAppleAvailbale=view.findViewById(R.id.tvAppleAvailable);
        btnGoToBuyApple=view.findViewById(R.id.btnGoToBuyApples);

        if(getArguments() !=null){
            tvAppleAvailbale.setText(getArguments().getString("currentAvailableApple"));
        }

        btnGoToBuyApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(totalAppleListener !=null){
                    Bundle bundle=new Bundle();
                    bundle.putString("apple",etAppleAvailable.getText().toString());
                    totalAppleListener.totalAppleListenerItem(bundle);
                    Toast.makeText(getContext(),"Happy Buy",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}