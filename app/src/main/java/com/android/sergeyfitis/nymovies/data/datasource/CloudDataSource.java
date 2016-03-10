package com.android.sergeyfitis.nymovies.data.datasource;

import com.android.sergeyfitis.nymovies.data.MoviesReviewsRetrofitApi;
import com.android.sergeyfitis.nymovies.data.db.MovieReview;
import com.android.sergeyfitis.nymovies.data.network.NetworkMovieReview;
import com.android.sergeyfitis.nymovies.utils.DataMapper;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public class CloudDataSource implements MovieReviewDataSource {
    private final MoviesReviewsRetrofitApi apiService;
    private final DbManager dbManager;

    public CloudDataSource(MoviesReviewsRetrofitApi apiService, DbManager dbManager) {
        this.apiService = apiService;
        this.dbManager = dbManager;
        saveToDb = (movieReviews) -> {
            if (dbManager != null) {
                dbManager.saveMovieReviews(movieReviews);
            }
        };
    }

    private final Action1<List<MovieReview>> saveToDb;

    @Override
    public Observable<List<MovieReview>> allReviews() {
        return apiService.allMoviesReviews()
                .map(reviewsResult -> {
                    final List<NetworkMovieReview> networkMovieReviewList = reviewsResult.getResults();
                    List<MovieReview> movieReviews = new ArrayList<>(networkMovieReviewList.size());
                    for (NetworkMovieReview networkMovieReview : networkMovieReviewList) {
                        MovieReview review = DataMapper.convertToMovieReview(networkMovieReview);
                        if (review != null) {
                            movieReviews.add(review);
                        }
                    }
                    return movieReviews;
                })
                .doOnNext(saveToDb);
    }

    @Override
    public Observable<MovieReview> movieReview(int reviewId) {
        return dbManager.movieReview(reviewId);
    }
}
