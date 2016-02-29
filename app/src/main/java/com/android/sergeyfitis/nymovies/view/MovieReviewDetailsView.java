package com.android.sergeyfitis.nymovies.view;

import com.android.sergeyfitis.nymovies.data.db.MovieReview;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public interface MovieReviewDetailsView extends LoadDataView {

    void renderMovieReview(MovieReview movieReview);

}
