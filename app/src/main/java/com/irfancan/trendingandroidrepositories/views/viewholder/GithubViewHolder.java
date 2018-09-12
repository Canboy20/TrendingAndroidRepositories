package com.irfancan.trendingandroidrepositories.views.viewholder;

import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.irfancan.trendingandroidrepositories.R;

public class GithubViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout mRepositoryNameRowLinearLayout;
    public TextView mRepositoryNameTextView;


    public GithubViewHolder(LinearLayout repoName) {
        super(repoName);
        mRepositoryNameRowLinearLayout = repoName;
        mRepositoryNameTextView = repoName.findViewById(R.id.nameOfRepo);

    }


}
