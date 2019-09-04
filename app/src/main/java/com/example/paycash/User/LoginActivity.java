package com.example.paycash.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.paycash.MainFragment;
import com.example.paycash.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvRegist;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvRegist = (TextView) findViewById(R.id.register);
        tvRegist.setOnClickListener(this);
        btnLogin = (Button) findViewById(R.id.tombol_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register :
                Intent i = new Intent(this,RegisterActivity.class);
                startActivity(i);
                break;
            case R.id.tombol_login:
                Intent j = new Intent(this, MainFragment.class);
                startActivity(j);
                break;
        }
    }
}
