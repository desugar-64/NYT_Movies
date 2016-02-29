package com.android.sergeyfitis.nymovies.data.datasource;

import com.android.sergeyfitis.nymovies.data.db.MovieReview;

import java.util.List;

import rx.Observable;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public interface DbManager {

    void saveMovieReviews(List<MovieReview> movieReviews);

    Observable<List<MovieReview>> allReviews();

    Observable<MovieReview> movieReview(int reviewId);

}
