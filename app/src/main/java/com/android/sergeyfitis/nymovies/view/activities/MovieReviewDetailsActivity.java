package com.android.sergeyfitis.nymovies.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.sergeyfitis.nymovies.R;
import com.android.sergeyfitis.nymovies.view.fragments.MovieReviewDetailsFragment;

public class MovieReviewDetailsActivity extends AppCompatActivity {

    public static final String KEY_MOVIE_REVIEW_ID = "key_movie_review_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_review_details);
        if (savedInstanceState == null) {
            int movieId = getIntent().getIntExtra(KEY_MOVIE_REVIEW_ID, 0);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_details_container, MovieReviewDetailsFragment.newInstance(movieId))
                    .commit();
        }
    }

    @Override
    protected void onDestroy() {
        overridePendingTransition(0, R.anim.slide_out_to_right);
        super.onDestroy();
    }
}
