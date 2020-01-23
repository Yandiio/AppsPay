package com.example.paycash;

import android.os.Bundle;
import android.view.MenuItem;

//import com.example.paycash.Fragment.R;
import com.example.paycash.ui.Profile.ProfileFragment;
import com.example.paycash.ui.chat.ChatFragment;
import com.example.paycash.ui.home.HomeFragment;
import com.example.paycash.ui.news.NewsFragment;
import com.example.paycash.ui.report.ReportFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainFragment extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment= null;
        switch (menuItem.getItemId()){
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_news:
                fragment = new NewsFragment();
                break;
            case R.id.navigation_report:
                fragment = new ReportFragment();
                break;
            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                break;

        }
        return loadFragment(fragment);
    }


    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction().replace(R.id.nav_host_view, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}




