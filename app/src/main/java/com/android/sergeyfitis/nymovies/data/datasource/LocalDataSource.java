package com.android.sergeyfitis.nymovies.data.datasource;

import com.android.sergeyfitis.nymovies.data.db.MovieReview;

import java.util.List;

import rx.Observable;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public class LocalDataSource implements MovieReviewDataSource {
    private final DbManager dbManager;

    public LocalDataSource(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public Observable<List<MovieReview>> allReviews() {
        return dbManager.allReviews();
    }

    @Override
    public Observable<MovieReview> movieReview(int reviewId) {
        return dbManager.movieReview(reviewId);
    }
}
