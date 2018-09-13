package com.irfancan.trendingandroidrepositories.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.irfancan.trendingandroidrepositories.R;
import com.irfancan.trendingandroidrepositories.constants.Constants;


public class RepoDetailsFragment extends Fragment {

    //Views
    private TextView repoNameTextView;
    private TextView authorTextView;
    private TextView descriptionTextView;
    private TextView numOfStarsTextView;
    private TextView numOfForksTextView;
    private TextView urlTextView;

    //private TextView currentPeriodStarsTextView;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.repo_details_fragment, container, false);

        repoNameTextView=rootView.findViewById(R.id.repoNameTextView);
        authorTextView=rootView.findViewById(R.id.authorTextView);
        descriptionTextView=rootView.findViewById(R.id.descriptionTextView);
        numOfStarsTextView=rootView.findViewById(R.id.numOfStarsTextView);
        numOfForksTextView=rootView.findViewById(R.id.numberOfForksTextView);
        urlTextView=rootView.findViewById(R.id.urlTextView);

        //currentPeriodStarsTextView=rootView.findViewById(R.id.languageTextView);
        return rootView;

    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Data retrieved from bundle will update views
        Bundle bundle = this.getArguments();
        if (bundle != null) {

            repoNameTextView.setText(bundle.getString(Constants.REPO_NAME));
            authorTextView.setText("by " + bundle.getString(Constants.REPO_AUTHOR));
            descriptionTextView.setText(bundle.getString(Constants.REPO_DESCRIPTION));
            numOfStarsTextView.setText( Integer.toString(bundle.getInt(Constants.REPO_STARS)));
            numOfForksTextView.setText( Integer.toString(bundle.getInt(Constants.REPO_FORKS)));
            urlTextView.setText(bundle.getString(Constants.REPO_URL));
            //currentPeriodStarsTextView.setText(bundle.getString(Constants.REPO_CURRENT_PERIOD_STARS));

        }

    }


}