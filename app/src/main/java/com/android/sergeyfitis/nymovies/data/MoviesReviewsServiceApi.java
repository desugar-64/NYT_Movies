package com.android.sergeyfitis.nymovies.data;

import com.android.sergeyfitis.nymovies.data.network.NetworkMovieReview;
import com.android.sergeyfitis.nymovies.data.network.NetworkMovieReviewsResult;

/**
 * Created by Serhii Yaremych on 28.02.2016.
 */
public interface MoviesReviewsServiceApi {

    interface MoviesReviewsServiceCallback<T> {
        void onLoaded(T reviews);
        void onLoadFailed(Throwable throwable);
    }

    void getAllMovieReviews(MoviesReviewsServiceCallback<NetworkMovieReviewsResult> callback);

    void getMovieReview(MoviesReviewsServiceCallback<NetworkMovieReview> callback);
}
