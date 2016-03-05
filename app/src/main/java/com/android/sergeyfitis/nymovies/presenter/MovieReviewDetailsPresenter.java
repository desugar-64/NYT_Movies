package com.android.sergeyfitis.nymovies.presenter;

import com.android.sergeyfitis.nymovies.data.db.MovieReview;
import com.android.sergeyfitis.nymovies.interactor.DefaultSubscriber;
import com.android.sergeyfitis.nymovies.interactor.UseCase;
import com.android.sergeyfitis.nymovies.view.MovieReviewDetailsView;

/**
 * Created by Serhii Yaremych on 05.03.2016.
 */
public class MovieReviewDetailsPresenter implements Presenter {

    private final UseCase mReviewUseCase;
    private final MovieReviewDetailsView mView;

    public MovieReviewDetailsPresenter(UseCase mReviewUseCase, MovieReviewDetailsView mView) {
        this.mReviewUseCase = mReviewUseCase;
        this.mView = mView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mReviewUseCase.unsubscribe();
    }

    public void initialize() {
        mReviewUseCase.execute(new MovieReviewDetailsSubscriber());
        mView.hideRetry();
        mView.showLoading();
    }

    private class MovieReviewDetailsSubscriber extends DefaultSubscriber<MovieReview> {
        @Override
        public void onCompleted() {
            super.onCompleted();
            mView.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mView.hideLoading();
            mView.showError(e.getMessage());
            mView.showRetry();
        }

        @Override
        public void onNext(MovieReview o) {
            super.onNext(o);
            mView.hideRetry();
            mView.hideLoading();
            mView.renderMovieReview(o);
        }
    }
}
