package com.android.sergeyfitis.nymovies.interactor;

import com.android.sergeyfitis.nymovies.data.datasource.MovieReviewDataSource;
import com.android.sergeyfitis.nymovies.executor.PostExecutionThread;
import com.android.sergeyfitis.nymovies.executor.ThreadExecutor;

import rx.Observable;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public class GetMovieReview extends UseCase {

    private final MovieReviewDataSource dataSource;
    private final int movieReviewId;

    public GetMovieReview(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, MovieReviewDataSource dataSource, int movieReviewId) {
        super(threadExecutor, postExecutionThread);
        this.dataSource = dataSource;
        this.movieReviewId = movieReviewId;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return dataSource.movieReview(movieReviewId);
    }
}
