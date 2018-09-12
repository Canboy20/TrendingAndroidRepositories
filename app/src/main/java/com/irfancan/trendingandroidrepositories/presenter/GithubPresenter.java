package com.irfancan.trendingandroidrepositories.presenter;

import android.content.Context;
import android.util.Log;

import com.irfancan.trendingandroidrepositories.constants.Constants;
import com.irfancan.trendingandroidrepositories.model.GithubRepo;
import com.irfancan.trendingandroidrepositories.network.GithubAndroidService;
import com.irfancan.trendingandroidrepositories.views.ViewContract;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubPresenter {

    private ViewContract mViewContract;

    private static Retrofit retrofit = null;


    //Constructor
    public GithubPresenter(ViewContract viewContract){

        mViewContract=viewContract;

    }


    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }





    //FETCH Popular Movies
    public void getAndroidReposFromGithub(){

        //Service that will fetch Android repos
        GithubAndroidService apiService = getClient().create(GithubAndroidService.class);


        apiService.getAndroidRepos("")
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
