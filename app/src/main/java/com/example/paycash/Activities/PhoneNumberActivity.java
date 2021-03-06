package com.example.paycash.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.paycash.R;


public class PhoneNumberActivity extends AppCompatActivity implements View.OnClickListener {

    public ImageButton btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        btnContinue = findViewById(R.id.btnContinue_pn);
        btnContinue.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnContinue_pn :
                Intent in = new Intent(this,PasscodeActivity.class);
                startActivity(in);
                finish();
        }
    }
}
