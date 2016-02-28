package com.android.sergeyfitis.nymovies.data;

import com.android.sergeyfitis.nymovies.data.network.NetworkMovieReview;
import com.android.sergeyfitis.nymovies.data.network.NetworkMovieReviewsResult;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Serhii Yaremych on 28.02.2016.
 */
public class MoviesReviewsServiceApiImpl implements MoviesReviewsServiceApi, Unsubscribable {

    private MoviesReviewsRetrofitApi manager;
    private final CompositeSubscription compositeSubscription = new CompositeSubscription();

    public MoviesReviewsServiceApiImpl(MoviesReviewsRetrofitApi manager) {
        this.manager = manager;
    }


    @Override
    public void getAllMovieReviews(MoviesReviewsServiceCallback<NetworkMovieReviewsResult> callback) {
        Subscription subscribe = manager.allMoviesReviews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onLoaded, callback::onLoadFailed);
        compositeSubscription.add(subscribe);
    }

    @Override
    public void getMovieReview(MoviesReviewsServiceCallback<NetworkMovieReview> callback) {
        // TODO: 28.02.2016 Implement
    }

    @Override
    public void unsubscribe() {
        if (compositeSubscription.hasSubscriptions()) {
            compositeSubscription.unsubscribe();
            compositeSubscription.clear();
        }
    }
}
