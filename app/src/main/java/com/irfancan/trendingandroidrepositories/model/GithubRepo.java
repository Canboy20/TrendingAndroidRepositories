package com.irfancan.trendingandroidrepositories.model;

import com.google.gson.annotations.SerializedName;

public class GithubRepo {

    /***This model will be used to parse Github API data**/

    @SerializedName("author")
    private String author;

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    @SerializedName("description")
    private String description;

    @SerializedName("stars")
    private int stars;

    @SerializedName("forks")
    private int forks;

    @SerializedName("currentPeriodStars")
    private int currentPeriodStars;




    public String getAuthor(){

        return author;

    }

    public String getName(){

        return name;

    }

    public String getUrl(){

        return url;

    }


    public String getDescription(){

        return description;

    }



    public int getStars(){

        return stars;

    }


    public int getForks(){

        return forks;

    }


    public int getCurrentPeriodStars(){

        return currentPeriodStars;

    }


}
