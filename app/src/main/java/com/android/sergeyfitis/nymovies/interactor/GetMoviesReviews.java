package com.android.sergeyfitis.nymovies.interactor;

import com.android.sergeyfitis.nymovies.data.datasource.MovieReviewDataSource;
import com.android.sergeyfitis.nymovies.executor.PostExecutionThread;
import com.android.sergeyfitis.nymovies.executor.ThreadExecutor;

import rx.Observable;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public class GetMoviesReviews extends UseCase {

    private final MovieReviewDataSource movieReviewDataSource;

    public GetMoviesReviews(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, MovieReviewDataSource movieReviewDataSource) {
        super(threadExecutor, postExecutionThread);
        this.movieReviewDataSource = movieReviewDataSource;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return movieReviewDataSource.allReviews();
    }
}
