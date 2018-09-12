package com.irfancan.trendingandroidrepositories.views.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.irfancan.trendingandroidrepositories.R;
import com.irfancan.trendingandroidrepositories.model.GithubRepo;
import com.irfancan.trendingandroidrepositories.presenter.GithubPresenter;
import com.irfancan.trendingandroidrepositories.views.adapter.GithubAdapter;
import com.irfancan.trendingandroidrepositories.views.ViewContract;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewContract {


    private RecyclerView mGithubRecyclerView;
    private RecyclerView.Adapter mGithubAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private GithubPresenter mGithubPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Presenter. Will follow MVP design pattern
        mGithubPresenter=new GithubPresenter(this);

        //Setups RecyclerView (view, adapter)
        setupRecyclerView();


        //Make request
        mGithubPresenter.getAndroidReposFromGithub();


    }




    private void setupRecyclerView(){

        mGithubRecyclerView = findViewById(R.id.github_repositories_recycler_view);
        mGithubRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mGithubRecyclerView.setLayoutManager(mLayoutManager);


    }



    //The methods below will be used to fill the recyclerview with data
    @Override
    public void updateRecyclerViewWithRepoData(List<GithubRepo> rootResponse) {

        //Dataset will be defined once model is ready
        mGithubAdapter = new GithubAdapter(rootResponse);
        mGithubRecyclerView.setAdapter(mGithubAdapter);


    }

    @Override
    public void displayError() {

    }
}
