package com.irfancan.trendingandroidrepositories.presenter;

import android.content.Context;
import android.util.Log;

import com.irfancan.trendingandroidrepositories.constants.Constants;
import com.irfancan.trendingandroidrepositories.model.GithubRepo;
import com.irfancan.trendingandroidrepositories.network.GithubAndroidService;
import com.irfancan.trendingandroidrepositories.network.service.RetrofitService;
import com.irfancan.trendingandroidrepositories.views.ViewContract;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class GithubPresenter {

    private ViewContract mViewContract;

    //Constructor
    public GithubPresenter(ViewContract viewContract){

        mViewContract=viewContract;

    }


    //FETCH Android Repositories. Will be fetched with RxJAVA
    // * onSuccess -> Will fill the recyclerview with list of trending repos
    // * onError   -> Will display an error message
    public void getAndroidReposFromGithub(){

        //Service that will fetch Android repos
        GithubAndroidService apiService = RetrofitService.getClient().create(GithubAndroidService.class);


        //PROGRAMMING_LANGUAGE_KOTLIN  ->  Since KOTLIN is the trending language now in Android, I decided to search trending repositories related to KOTLIN rather than JAVA
        apiService.getAndroidRepos(Constants.PROGRAMMING_LANGUAGE_KOTLIN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<GithubRepo>>() {
                    @Override
                    public void onSuccess(List<GithubRepo> rootResponse) {

                        Log.d("REQUEST SUCCESS","SUCCESS");
                        mViewContract.updateRecyclerViewWithRepoData(rootResponse);

                    }

                    @Override
                    public void onError(Throwable e) {

                        // Network error
                        Log.d("REQUEST FAILED","FAILED");
                        mViewContract.displayError();


                    }
                });



    }


}
