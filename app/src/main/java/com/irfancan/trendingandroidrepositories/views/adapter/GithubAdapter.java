package com.irfancan.trendingandroidrepositories.views.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.irfancan.trendingandroidrepositories.R;
import com.irfancan.trendingandroidrepositories.views.viewholder.GithubViewHolder;

public class GithubAdapter extends RecyclerView.Adapter<GithubViewHolder> {

    //Will change this once I create model
    private String[] mDataset;


    // Adapter Constructor
    public GithubAdapter(String[] myDataset) {
        mDataset = myDataset;
    }


    @Override
    public GithubViewHolder onCreateViewHolder(ViewGroup parent,

                                                     int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repository_name_row, parent, false);

        GithubViewHolder vh = new GithubViewHolder(v);
        return vh;

    }


    @Override
    public void onBindViewHolder(GithubViewHolder holder, int position) {


        holder.mRepositoryNameTextView.setText(mDataset[position]);

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
