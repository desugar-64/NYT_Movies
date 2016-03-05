package com.android.sergeyfitis.nymovies.interactor;

import com.android.sergeyfitis.nymovies.data.datasource.DataSourceFactory;
import com.android.sergeyfitis.nymovies.data.datasource.DbManagerImpl;
import com.android.sergeyfitis.nymovies.executor.JobExecutor;
import com.android.sergeyfitis.nymovies.executor.UiThread;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public class UseCasesFactory {

    private static final JobExecutor sJobExecutor = new JobExecutor();

    private UseCasesFactory() {}

    public static GetMoviesReviews newMoviesReviewsUseCase() {
        return new GetMoviesReviews(
            sJobExecutor, UiThread.sInstance, DataSourceFactory.create(new DbManagerImpl()));
    }

    public static GetMovieReview newMovieReviewUseCase(int movieReviewId) {
        return new GetMovieReview(
                sJobExecutor, UiThread.sInstance, DataSourceFactory.create(new DbManagerImpl()), movieReviewId);
    }
}
