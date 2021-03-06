package com.example.paycash.ui.news;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

//import com.example.paycash.Fragment.R;
import com.example.paycash.Activities.NewsActivity;
import com.example.paycash.R;

public class NewsFragment extends Fragment {


    View view;
    private FragmentActivity myContext;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_news_home,container,false);

        final Button button = (Button) view.findViewById(R.id.btnPopular);
        final Button fin = (Button) view.findViewById(R.id.btnFinance);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                button.setSelected(true);
                button.setTextColor(Color.parseColor("#FFFFFF"));

                button.setTextColor(Color.parseColor("#F65151"));
                button.setSelected(false);

            }
        });

        fin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                fin.setSelected(true);
                fin.setTextColor(Color.parseColor("#FFFFFF"));

                fin.setTextColor(Color.parseColor("#F65151"));
                fin.setSelected(false);


                Intent i = new Intent(getActivity(), NewsActivity.class);
                startActivity(i);

            }
        });


        return view;
    }


}