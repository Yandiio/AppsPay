package com.example.paycash.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.paycash.R;

public class CheckoutActivity extends AppCompatActivity {

    Button onClickchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        onClickchange = findViewById(R.id.nextOrder);

        onClickchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CheckoutActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_payment_method,null);
                final RelativeLayout relLay1 = (RelativeLayout) mView.findViewById(R.id.ewalletPay);
                final RelativeLayout relLay2 = (RelativeLayout) mView.findViewById(R.id.cashPay);

                relLay1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                relLay2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent in = new Intent(CheckoutActivity.this, BarcodeActivity.class);
                        startActivity(in);
                        finish();
                    }
                });


                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

    }


}
