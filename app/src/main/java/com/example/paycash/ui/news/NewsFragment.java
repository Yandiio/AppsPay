package com.example.paycash.ui.news;

import android.app.Activity;
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
                button.setTextColor(Color.parseColor("#FFFFFFF"));

                button.setTextColor(Color.parseColor("#F65151"));
                button.setSelected(false);

                Fragment fragment = new PopularFrag();
                FragmentManager f = myContext.getSupportFragmentManager();
                FragmentTransaction fragT = f.beginTransaction();
                fragT.add(R.id.contentwrap,fragment);
                fragT.commit();
            }
        });

        fin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                fin.setSelected(true);
                fin.setTextColor(Color.parseColor("#FFFFFFF"));

                fin.setTextColor(Color.parseColor("#F65151"));
                fin.setSelected(false);

                Fragment fragment = new FinanceFrag();
                FragmentManager  frm = myContext.getSupportFragmentManager();
                FragmentTransaction ft = frm.beginTransaction();
                ft.add(R.id.contentwrap,fragment);
                ft.commit();
            }
        });


        return view;
    }


}