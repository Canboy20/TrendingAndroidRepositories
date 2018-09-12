package com.irfancan.trendingandroidrepositories.views.viewholder;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class GithubViewHolder extends RecyclerView.ViewHolder {

    public TextView mRepositoryNameTextView;

    public GithubViewHolder(TextView repoName) {
        super(repoName);
        mRepositoryNameTextView = repoName;
    }


}
