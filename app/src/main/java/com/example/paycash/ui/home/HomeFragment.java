package com.example.paycash.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.paycash.R;
import com.example.paycash.Activities.SelectMonthActivity;
import com.example.paycash.ui.ModalBottomSheet;


public class HomeFragment extends Fragment {

    public ImageView img1,img2,img3,img4,more,addMoney;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_home,container,false);
        img1 = v.findViewById(R.id.imgPay);
        img2 = v.findViewById(R.id.imgTopup);
        img3 = v.findViewById(R.id.imgReq);
        img4 = v.findViewById(R.id.imgMore);


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 ModalBottomSheet modalBottomSheet = new ModalBottomSheet();
                 modalBottomSheet.show(getFragmentManager(),"ExampleTagBottomDialog");;
            }
        });

        return v;
    }
}