package com.android.sergeyfitis.nymovies.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.sergeyfitis.nymovies.R;
import com.android.sergeyfitis.nymovies.data.db.MovieReview;
import com.android.sergeyfitis.nymovies.interactor.UseCasesFactory;
import com.android.sergeyfitis.nymovies.presenter.MoviesReviewsPresenter;
import com.android.sergeyfitis.nymovies.utils.ItemDecorationAlbumColumns;
import com.android.sergeyfitis.nymovies.view.MoviesReviewsListView;
import com.android.sergeyfitis.nymovies.view.adapters.MoviesReviewsAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesReviewsFragment extends Fragment implements MoviesReviewsListView {

    public static final String TAG = "MoviesReviewsFragment";

    @Bind(R.id.rv_movies_reviews)
    RecyclerView rvList;
    @Bind(R.id.pb_loading)
    ProgressBar progressBar;

    private MoviesReviewsPresenter presenter;


    public static MoviesReviewsFragment newInstance() {
        return new MoviesReviewsFragment();
    }


    public MoviesReviewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MoviesReviewsPresenter(this, UseCasesFactory.newMoviesReviewsUseCase());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_reviews, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        rvList.setLayoutManager(layoutManager);
        int padding = getResources().getDimensionPixelSize(R.dimen.medium_padding);
        rvList.addItemDecoration(new ItemDecorationAlbumColumns(padding, 3));
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
        presenter.destroy();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.initialize();
    }

    @Override
    public void renderMoviesReviews(List<MovieReview> movieReviews) {
        updateUI(movieReviews);
    }

    @Override
    public void viewMovieReview(MovieReview movieReview) {

    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRetry() {
        // TODO: 29.02.2016 implement
    }

    @Override
    public void hideRetry() {
        // TODO: 29.02.2016 implement
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideError() {
        // do nothing
    }


    private void updateUI(List<MovieReview> movieReviews) {
        MoviesReviewsAdapter adapter = new MoviesReviewsAdapter(movieReviews);
        rvList.setAdapter(adapter);
    }
}
