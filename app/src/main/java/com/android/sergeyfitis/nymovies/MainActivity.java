package com.android.sergeyfitis.nymovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.sergeyfitis.nymovies.view.fragments.MoviesReviewsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, MoviesReviewsFragment.newInstance(), MoviesReviewsFragment.TAG)
                    .commit();
        }
    }
}
