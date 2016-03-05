package com.android.sergeyfitis.nymovies.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.sergeyfitis.nymovies.R;
import com.android.sergeyfitis.nymovies.data.db.MovieLink;
import com.android.sergeyfitis.nymovies.data.db.MovieReview;
import com.android.sergeyfitis.nymovies.interactor.UseCasesFactory;
import com.android.sergeyfitis.nymovies.presenter.MovieReviewDetailsPresenter;
import com.android.sergeyfitis.nymovies.view.MovieReviewDetailsView;
import com.android.sergeyfitis.nymovies.view.activities.MovieReviewDetailsActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieReviewDetailsFragment extends Fragment implements MovieReviewDetailsView {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.iv_big_poster)
    ImageView ivBigPoster;
    @Bind(R.id.tv_mpaa_rating)
    TextView tvMpaaRating;
    @Bind(R.id.iv_small_poster)
    ImageView ivSmallPoster;
    @Bind(R.id.ll_related_items_container)
    LinearLayout llRelatedItemsContainer;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_description)
    TextView tvDescription;
    @Bind(R.id.ll_content)
    LinearLayout llContent;

    private int movieReviewId;

    private MovieReviewDetailsPresenter mPresenter;

    public MovieReviewDetailsFragment() {
        // Required empty public constructor
    }

    public static MovieReviewDetailsFragment newInstance(int movieReviewId) {
        MovieReviewDetailsFragment fragment = new MovieReviewDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(MovieReviewDetailsActivity.KEY_MOVIE_REVIEW_ID, movieReviewId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieReviewId = getArguments().getInt(MovieReviewDetailsActivity.KEY_MOVIE_REVIEW_ID);
        mPresenter = new MovieReviewDetailsPresenter(UseCasesFactory.newMovieReviewUseCase(movieReviewId), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_review_details, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.initialize();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        mPresenter.destroy();
    }

    @OnClick(R.id.btn_read_more)
    public void onClick() {
    }

    private void updateUI(MovieReview review) {
        tvTitle.setText(review.getDisplayTitle());
        tvDescription.setText(review.getSummaryShort());
        tvMpaaRating.setText(review.getMpaaRating());
        inflateRelated(review.getRelatedUrls());
    }

    private void inflateRelated(List<MovieLink> links) {
        LayoutInflater layoutInflater = getLayoutInflater(null);
        llRelatedItemsContainer.removeAllViews();
        for (int i = 0; i < links.size(); i++) {
            MovieLink link = links.get(i);
            View v = layoutInflater.inflate(R.layout.relater_item_layout, llRelatedItemsContainer, false);
            TextView title = ButterKnife.findById(v, R.id.tv_related_text);
            title.setText(link.getType());
            title.setOnClickListener(v1 -> Toast.makeText(getContext(), link.getUrl(), Toast.LENGTH_SHORT).show());
            llRelatedItemsContainer.addView(v);
        }
    }

    @Override
    public void renderMovieReview(MovieReview movieReview) {
        updateUI(movieReview);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void hideError() {

    }
}
