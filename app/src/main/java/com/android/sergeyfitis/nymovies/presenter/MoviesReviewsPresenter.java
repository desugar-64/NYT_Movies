package com.android.sergeyfitis.nymovies.presenter;

import com.android.sergeyfitis.nymovies.data.db.MovieReview;
import com.android.sergeyfitis.nymovies.interactor.DefaultSubscriber;
import com.android.sergeyfitis.nymovies.interactor.UseCase;
import com.android.sergeyfitis.nymovies.view.MoviesReviewsListView;

import java.util.List;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public class MoviesReviewsPresenter implements Presenter {

    private final MoviesReviewsListView reviewsListView; // Not real widget ListView!!!
    private final UseCase getMoviesReviewsUseCase;

    public MoviesReviewsPresenter(MoviesReviewsListView reviewsListView, UseCase getMoviesReviewsUseCase) {
        this.reviewsListView = reviewsListView;
        this.getMoviesReviewsUseCase = getMoviesReviewsUseCase;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getMoviesReviewsUseCase.unsubscribe();
    }

    public void initialize() {
        this.loadList();
    }

    private void loadList() {
        this.reviewsListView.hideRetry();
        this.reviewsListView.showLoading();
        this.getList();
    }

    private void getList() {
        this.getMoviesReviewsUseCase.execute(new MoviesReviewsSubscriber());
    }

    private final class MoviesReviewsSubscriber extends DefaultSubscriber<List<MovieReview>> {
        @Override
        public void onCompleted() {
            MoviesReviewsPresenter.this.reviewsListView.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            MoviesReviewsPresenter.this.reviewsListView.hideLoading();
            MoviesReviewsPresenter.this.reviewsListView.showError(e.getMessage());
            MoviesReviewsPresenter.this.reviewsListView.showRetry();
        }

        @Override
        public void onNext(List<MovieReview> movieReviews) {
            MoviesReviewsPresenter.this.reviewsListView.renderMoviesReviews(movieReviews);
        }
    }
}
