package com.android.sergeyfitis.nymovies.view;

import com.android.sergeyfitis.nymovies.data.db.MovieReview;

import java.util.List;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public interface MoviesReviewsListView extends LoadDataView {

    void renderMoviesReviews(List<MovieReview> movieReviews);

    void viewMovieReview(MovieReview movieReview);

}
