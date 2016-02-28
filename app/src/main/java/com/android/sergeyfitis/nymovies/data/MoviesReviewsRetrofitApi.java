package com.android.sergeyfitis.nymovies.data;

import com.android.sergeyfitis.nymovies.data.network.C;
import com.android.sergeyfitis.nymovies.data.network.NetworkMovieReviewsResult;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Serhii Yaremych on 28.02.2016.
 */
public interface MoviesReviewsRetrofitApi {

    @GET(C.ALL_REVIEWS)
    Observable<NetworkMovieReviewsResult> allMoviesReviews();
}
