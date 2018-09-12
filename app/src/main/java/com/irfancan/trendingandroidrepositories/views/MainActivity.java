package com.irfancan.trendingandroidrepositories.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.irfancan.trendingandroidrepositories.R;
import com.irfancan.trendingandroidrepositories.views.adapter.GithubAdapter;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mGithubRecyclerView;
    private RecyclerView.Adapter mGithubAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setups RecyclerView (view, adapter)
        setupRecyclerView();





    }




    private void setupRecyclerView(){

        mGithubRecyclerView = findViewById(R.id.github_repositories_recycler_view);
        mGithubRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mGithubRecyclerView.setLayoutManager(mLayoutManager);

        //Dataset will be defined once model is ready
        mGithubAdapter = new GithubAdapter(repositoriesDataset);
        mGithubRecyclerView.setAdapter(mGithubAdapter);

    }
}
