package com.irfancan.trendingandroidrepositories.views;

import com.irfancan.trendingandroidrepositories.model.GithubRepo;

import java.util.List;

public interface ViewContract {

    //Will fill the recyclerview with list of trending repos
    void updateRecyclerViewWithRepoData(List<GithubRepo> rootResponse);

    //Will display error message in the middle of screen
    void displayError();

}
