package com.example.paycash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.paycash.MainActivity;
import com.example.paycash.MainFragment;
import com.example.paycash.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvRegist;
    public EditText editMail,editPassw;
    Button btnLogin;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvRegist = (TextView) findViewById(R.id.register);
        tvRegist.setOnClickListener(this);
        btnLogin = (Button) findViewById(R.id.tombol_login);

        editPassw = (EditText) findViewById(R.id.editPass);
        editMail = (EditText) findViewById(R.id.editUsern);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = editMail.getText().toString();
                final String password = editPassw.getText().toString();

                if(email.isEmpty() || password.isEmpty()){
                    showMessage("Please Verify All Password");
                }
                else{
                    signIn(email,password);
                }
            }
        });
    }

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    updateUI();
                }else{
                    showMessage(task.getException().getMessage());
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser a = mAuth.getCurrentUser();

        if(a != null){
            updateUI();
            
        }
    }

    private void updateUI() {
        Intent in = new Intent(getApplicationContext(),MainFragment.class);
        startActivity(in);
        finish();
    }

    private void showMessage(String text) {
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register :
                Intent i = new Intent(this,RegisterActivity.class);
                startActivity(i);
                break;
        }
    }
}