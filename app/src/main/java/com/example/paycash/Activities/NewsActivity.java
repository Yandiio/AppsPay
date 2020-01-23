package com.example.paycash.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Toast;

import com.example.paycash.Adapters.NewsHolderAdapter;
import com.example.paycash.ApiClient;
import com.example.paycash.Models.Articles;
import com.example.paycash.Models.News;
import com.example.paycash.R;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    final String API_KEY = "62ca3ccb59494c8ba61e86151b116624";
    NewsHolderAdapter adapter;
    List<Articles> articles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final String Country = getCountry();

        swipeRefreshLayout = findViewById(R.id.refreshList);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                retrieveData(Country,API_KEY);
            }
        });

        retrieveData(Country,API_KEY);
 
    }

    public void retrieveData(String Country,String apiKey){
        Call<News> call = ApiClient.getInstance().getApi().getHeadlines(Country,apiKey);
        call.enqueue(new Callback<News>(){

            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if(response.isSuccessful() && response.body().getArticles() != null)
                    articles.clear();
                articles = response.body().getArticles();
                adapter = new NewsHolderAdapter(NewsActivity.this,articles);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    public String getCountry()
    {
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }



}
