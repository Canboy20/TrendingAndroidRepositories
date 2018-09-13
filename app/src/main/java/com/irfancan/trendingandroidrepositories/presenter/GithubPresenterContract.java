package com.irfancan.trendingandroidrepositories.presenter;

public interface GithubPresenterContract {

    //Will fetch list of trending repos from Github(With RxJAVA and Retrofit)
    void getAndroidReposFromGithub();

    //This will be used to stop API request made by presenter in case fragment is detached while trying to fetch Github repos list
    void detachView();

}
