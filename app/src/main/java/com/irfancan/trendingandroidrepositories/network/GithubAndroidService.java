package com.irfancan.trendingandroidrepositories.network;

import com.irfancan.trendingandroidrepositories.model.GithubRepo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubAndroidService {

    @GET("/repositories?")
    Single<List<GithubRepo>> getAndroidRepos(@Query("language") String language);

}
