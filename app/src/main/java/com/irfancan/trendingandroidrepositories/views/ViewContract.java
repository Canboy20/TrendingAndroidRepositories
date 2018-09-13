package com.irfancan.trendingandroidrepositories.views;

import com.irfancan.trendingandroidrepositories.model.GithubRepo;

import java.util.List;

public interface ViewContract {

    void updateRecyclerViewWithRepoData(List<GithubRepo> rootResponse);

    void displayError();


}
