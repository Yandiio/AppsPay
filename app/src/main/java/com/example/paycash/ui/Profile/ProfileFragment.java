package com.example.paycash.ui.Profile;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.paycash.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

//import com.example.paycash.Fragment.R;

public class ProfileFragment extends Fragment {
    private Uri pickedImgUri = null;

    TextView name,email,google;
    FirebaseAuth firebaseAuth;
    View v;
    ImageView imgView;
    FirebaseUser firebaseUser;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View views = inflater.inflate(R.layout.fragment_profile,container,false);
        updateNavHeader();

        return views;
    }

    private void updateNavHeader() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        TextView textView = v.findViewById(R.id.txName);
        TextView textView2 = v.findViewById(R.id.txtEmail);
        ImageView imgView = v.findViewById(R.id.imgProfile);

        textView.setText(firebaseUser.getDisplayName());
        textView2.setText(firebaseUser.getEmail());
        Picasso.get()
                .load(firebaseUser.getPhotoUrl())
                .into(imgView);
    }

}