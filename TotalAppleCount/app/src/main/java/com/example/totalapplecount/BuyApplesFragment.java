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
import android.widget.Toast;


public class BuyApplesFragment extends Fragment {

    private EditText etNoOfBuyApple;
    private Button btnBuy;
    private BuyAppleListener buyAppleListener;
    private int currentApple=0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_apples, container, false);
    }

    @Override
    public void onAttach(@NonNull  Context context) {
        super.onAttach(context);
        buyAppleListener= (BuyAppleListener) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // initializing the view
        etNoOfBuyApple=view.findViewById(R.id.etNoOfBuyApple);
        btnBuy=view.findViewById(R.id.btnBuy);

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=getArguments();

                if(getArguments() !=null){
                    currentApple=Integer.parseInt(bundle.getString("apple")) - Integer.parseInt(etNoOfBuyApple.getText().toString());
                    Toast.makeText(getContext(),"Current Apple",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if(buyAppleListener !=null){
            Bundle bundle=new Bundle();
            bundle.putString("currentAvailableApple",String.valueOf(currentApple));
            buyAppleListener.buyAppleListenerItem(bundle);
            Toast.makeText(getContext(),"Visit the store again",Toast.LENGTH_SHORT).show();
        }
    }
}