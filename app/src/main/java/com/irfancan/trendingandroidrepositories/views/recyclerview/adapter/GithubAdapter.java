package com.irfancan.trendingandroidrepositories.views.recyclerview.adapter;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.irfancan.trendingandroidrepositories.R;
import com.irfancan.trendingandroidrepositories.model.GithubRepo;
import com.irfancan.trendingandroidrepositories.views.recyclerview.listeners.RowClickListener;
import com.irfancan.trendingandroidrepositories.views.recyclerview.viewholder.GithubViewHolder;

import java.util.List;

public class GithubAdapter extends RecyclerView.Adapter<GithubViewHolder> {

    //Will change this once I create model
    private List<GithubRepo> mAndroidRepos;
    private RowClickListener mRowClickListener;


    // Adapter Constructor
    public GithubAdapter(List<GithubRepo> androidRepos,RowClickListener rowClickListener) {
        mAndroidRepos = androidRepos;
        mRowClickListener = rowClickListener;

    }


    @Override
    public GithubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repository_name_row, parent, false);

        GithubViewHolder vh = new GithubViewHolder(v);
        return vh;

    }


    @Override
    public void onBindViewHolder(final GithubViewHolder holder, final int position) {


        holder.mRepositoryNameTextView.setText(mAndroidRepos.get(position).getName());
        holder.mRepositoryNameRowLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRowClickListener.rowClickListener(mAndroidRepos.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mAndroidRepos.size();
    }
}
