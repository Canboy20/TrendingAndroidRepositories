package com.irfancan.trendingandroidrepositories.views.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.irfancan.trendingandroidrepositories.R;
import com.irfancan.trendingandroidrepositories.constants.Constants;
import com.irfancan.trendingandroidrepositories.model.GithubRepo;
import com.irfancan.trendingandroidrepositories.views.recyclerview.adapter.GithubAdapter;
import com.irfancan.trendingandroidrepositories.views.fragments.RepoDetailsFragment;
import com.irfancan.trendingandroidrepositories.views.fragments.ReposListFragment;
import com.irfancan.trendingandroidrepositories.views.recyclerview.listeners.RowClickListener;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        //There are two types of fragments. ReposListFragment (Contains a list of trending repos) and RepoDetailsFragment(displays details of a repo )
        //At start the list of trending repos will be displayed
        startFragmentTransaction(Constants.REPOS_LIST_FRAGMENT,null);

    }




    public void startFragmentTransaction(String fragmentConstant,GithubRepo githubRepo){

        if(fragmentConstant.equals(Constants.REPOS_LIST_FRAGMENT)){


            ReposListFragment reposListFragment = new ReposListFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, reposListFragment).addToBackStack(null).commit();



        }else if(fragmentConstant.equals(Constants.REPO_DETAILS_FRAGMENT)){


            RepoDetailsFragment repoDetailsFragment = new RepoDetailsFragment();

            if(githubRepo!=null){

                Bundle repoDetailsBundle = new Bundle();
                repoDetailsBundle.putString(Constants.REPO_AUTHOR, githubRepo.getAuthor());
                repoDetailsBundle.putString(Constants.REPO_NAME, githubRepo.getName());
                repoDetailsBundle.putString(Constants.REPO_URL, githubRepo.getUrl());
                repoDetailsBundle.putString(Constants.REPO_DESCRIPTION, githubRepo.getDescription());
                repoDetailsBundle.putInt(Constants.REPO_STARS, githubRepo.getStars());
                repoDetailsBundle.putInt(Constants.REPO_FORKS, githubRepo.getForks());
                repoDetailsBundle.putInt(Constants.REPO_CURRENT_PERIOD_STARS, githubRepo.getCurrentPeriodStars());
                repoDetailsFragment.setArguments(repoDetailsBundle);
             }

            getSupportFragmentManager()
                    .beginTransaction().setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left)
                    .replace(R.id.fragmentContainer, repoDetailsFragment).addToBackStack(null).commit();
        }






    }



}
