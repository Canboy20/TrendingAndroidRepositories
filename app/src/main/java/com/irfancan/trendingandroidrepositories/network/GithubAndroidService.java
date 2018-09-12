package com.irfancan.trendingandroidrepositories.network;

import com.irfancan.trendingandroidrepositories.model.GithubRepo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubAndroidService {

    @GET("/users/{user}/repos")
    Single<List<GithubRepo>> getAndroidRepos(@Path("user") String user);

}
