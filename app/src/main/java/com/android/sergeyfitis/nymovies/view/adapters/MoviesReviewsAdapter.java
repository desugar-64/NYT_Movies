package com.android.sergeyfitis.nymovies.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.sergeyfitis.nymovies.R;
import com.android.sergeyfitis.nymovies.data.db.MovieReview;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public class MoviesReviewsAdapter extends RecyclerView.Adapter<MoviesReviewsAdapter.ReviewViewHolder> {

    private List<MovieReview> movieReviews;

    public MoviesReviewsAdapter(List<MovieReview> movieReviews) {
        this.movieReviews = movieReviews;
    }

    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReviewViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.movie_item_layout, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(ReviewViewHolder holder, int position) {
        holder.bindModel(movieReviews.get(position));
    }

    @Override
    public int getItemCount() {
        return movieReviews == null ? 0 : movieReviews.size();
    }

    class ReviewViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_movie_poster)
        ImageView ivPoster;
        @Bind(R.id.tv_movie_title)
        TextView tvTitle;

        public ReviewViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindModel(MovieReview movieReview) {
            tvTitle.setText(movieReview.getDisplayTitle());
            // TODO: 29.02.2016 show poster
        }
    }
}
