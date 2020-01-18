package com.example.paycash.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.paycash.PhoneNumberActivity;
import com.example.paycash.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnRegist;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tvLogin = (TextView) findViewById(R.id.login);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent j = new Intent(this, PhoneNumberActivity.class);
        startActivity(j);
    }
}
