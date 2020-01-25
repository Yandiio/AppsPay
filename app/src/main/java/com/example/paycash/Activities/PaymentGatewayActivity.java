package com.example.paycash.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.paycash.R;
import com.midtrans.sdk.corekit.callback.TransactionFinishedCallback;
import com.midtrans.sdk.corekit.models.snap.TransactionResult;

public class PaymentGatewayActivity extends AppCompatActivity implements TransactionFinishedCallback {

    public RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_gateway);

        radioGroup = findViewById(R.id.list_product);

    }

    @Override
    public void onTransactionFinished(TransactionResult transactionResult) {
        if (transactionResult.getResponse() != null) {
            switch (transactionResult.getStatus()) {
                case TransactionResult.STATUS_SUCCESS:
                    Toast.makeText(this, "Success transaction", Toast.LENGTH_LONG).show();
                case TransactionResult.STATUS_PENDING:
                    Toast.makeText(this, "Pending transaction", Toast.LENGTH_LONG).show();
                case TransactionResult.STATUS_FAILED:
                    Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show();
            }
        }
    }
}

