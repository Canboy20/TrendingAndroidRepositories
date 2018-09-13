package com.irfancan.trendingandroidrepositories.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.irfancan.trendingandroidrepositories.R;
import com.irfancan.trendingandroidrepositories.constants.Constants;
import com.irfancan.trendingandroidrepositories.model.GithubRepo;
import com.irfancan.trendingandroidrepositories.presenter.GithubPresenter;
import com.irfancan.trendingandroidrepositories.views.ViewContract;
import com.irfancan.trendingandroidrepositories.views.activitys.MainActivity;
import com.irfancan.trendingandroidrepositories.views.recyclerview.adapter.GithubAdapter;
import com.irfancan.trendingandroidrepositories.views.recyclerview.listeners.RowClickListener;

import java.util.List;

public class ReposListFragment extends Fragment implements ViewContract,RowClickListener {


    //RecyclerView Parameters
    private RecyclerView mGithubRecyclerView;
    private RecyclerView.Adapter mGithubAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private GithubPresenter mGithubPresenter;

    //ProgressBar
    private ProgressBar progressBar;

    //Error TextView
    private TextView errorOccuredTextView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.repo_list_fragment, container, false);

        //Presenter. Will follow MVP design pattern
        mGithubPresenter=new GithubPresenter(this);

        //Setups RecyclerView (view, adapter)
        setupRecyclerView(rootView);

        //ProgressBar
        progressBar=rootView.findViewById(R.id.progressBar);

        //Error TextView
        errorOccuredTextView=rootView.findViewById(R.id.errorOccuredTextView);

        //Make request
        mGithubPresenter.getAndroidReposFromGithub();

        return rootView;
    }



    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }




    private void setupRecyclerView(View rootViewRef){

        mGithubRecyclerView = rootViewRef.findViewById(R.id.github_repositories_recycler_view);
        mGithubRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mGithubRecyclerView.setLayoutManager(mLayoutManager);


    }



    //The methods below will be used to fill the recyclerview with data
    @Override
    public void updateRecyclerViewWithRepoData(List<GithubRepo> rootResponse) {

        progressBar.setVisibility(View.GONE);
        mGithubRecyclerView.setVisibility(View.VISIBLE);
        errorOccuredTextView.setVisibility(View.GONE);


        //Dataset will be defined once model is ready
        mGithubAdapter = new GithubAdapter(rootResponse,this);
        mGithubRecyclerView.setAdapter(mGithubAdapter);
    }


    @Override
    public void displayError() {

        progressBar.setVisibility(View.GONE);
        mGithubRecyclerView.setVisibility(View.INVISIBLE);

        //Display 'An error occured' text
        errorOccuredTextView.setVisibility(View.VISIBLE);

    }


    //This will be called when user clicks at a row in the Repo List
    //Upon clicking, the Repo Details Fragment will be displayed which will display more info about the repo user selected from list
    @Override
    public void rowClickListener(GithubRepo githubRepo) {

        //Just being extra careful
        if((getActivity())!=null){

            ((MainActivity)getActivity()).startFragmentTransaction(Constants.REPO_DETAILS_FRAGMENT,githubRepo);

        }

    }
}