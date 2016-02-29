package com.android.sergeyfitis.nymovies.view;

import android.content.Context;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public interface LoadDataView {

    void showLoading();

    void hideLoading();

    void showRetry();

    void hideRetry();

    void showError(String message);

    void hideError();

    Context getContext();

}
