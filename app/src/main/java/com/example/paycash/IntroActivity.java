package com.example.paycash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    ScreenIntroViewAdapter ScreenIntroViewAdapter;

    TextView tvSkip;
    Button btnGetStarted, btnNext;
    int getPosition = 0;
    TabLayout tabIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (restorePrefData()) {
//            Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(mainActivity);
            finish();
        }

//        fill list screen
        final List<ScreenView> mList = new ArrayList<>();
        mList.add(new ScreenView("Easy Payment", "in Paycash,no need to top up", R.drawable.img1));
        mList.add(new ScreenView("Fast Performance", "Fast Performance is important to Keep it up", R.drawable.img2));
        mList.add(new ScreenView("Keep Passionate", "Have You ever heard,Just Do it?", R.drawable.img3));


        ScreenIntroViewAdapter = new ScreenIntroViewAdapter(this, mList);
        screenPager = findViewById(R.id.screen_viewpager);
        screenPager.setAdapter(ScreenIntroViewAdapter);

        tabIndicator.setupWithViewPager(screenPager);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPosition = screenPager.getCurrentItem();
                if (getPosition < mList.size()) {

                    getPosition++;
                    screenPager.setCurrentItem(getPosition);


                }

                if (getPosition == mList.size() - 1) { // when we rech to the last screen

                    // TODO : show the GETSTARTED Button and hide the indicator and the next button

                    loadLastScreen();

                }

            }
        });

        btnGetStarted.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
//                Intent start = new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(start);
                savePrefData();
                finish();
            }

            });
;
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size() - 1) {
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tvSkip.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                screenPager.setCurrentItem(mList.size());
            }
        });
    }

    private void savePrefData(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend",true);
        editor.commit();
    }

    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("my Prefer", MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = pref.getBoolean("isIntroOpened", false);
        return isIntroActivityOpenedBefore;
    }

    private void loadLastScreen() {
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tvSkip.setVisibility(View.INVISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
//        btnGetStarted.setAnimation(btn_anim);
    }
}
