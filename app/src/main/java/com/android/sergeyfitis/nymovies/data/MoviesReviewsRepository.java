package com.android.sergeyfitis.nymovies.data;

import android.support.annotation.NonNull;

import com.android.sergeyfitis.nymovies.data.network.NetworkMovieReview;
import com.android.sergeyfitis.nymovies.data.network.NetworkMovieReviewsResult;

/**
 * Created by Serhii Yaremych on 28.02.2016.
 */
public interface MoviesReviewsRepository {

    interface LoadMoviesReviewsCallback {
        void onMoviesReviewsLoaded(@NonNull NetworkMovieReviewsResult reviewsResult);
        void onLoadFailed(@NonNull Throwable throwable);
    }

    interface GetMovieReviewCallback {
        void onMovieReviewLoaded(@NonNull NetworkMovieReview movieReview);
        void onLoadFailed(@NonNull Throwable throwable);
    }

    void getMoviesReviews(@NonNull LoadMoviesReviewsCallback callback);

    void getMovieReview(@NonNull GetMovieReviewCallback callback);

    void refreshData();
}
