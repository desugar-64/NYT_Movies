package com.android.sergeyfitis.nymovies;

import android.support.annotation.VisibleForTesting;

import com.android.sergeyfitis.nymovies.data.MoviesRequestManager;
import com.android.sergeyfitis.nymovies.data.MoviesReviewsRetrofitApi;
import com.android.sergeyfitis.nymovies.data.datasource.CloudDataSource;
import com.android.sergeyfitis.nymovies.data.db.MovieReview;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import rx.observers.TestSubscriber;

/**
 * Created by Serhii Yaremych on 10.03.2016.
 */


public class CloudDataSourceTest {

    @VisibleForTesting
    MoviesReviewsRetrofitApi retrofitApi;
    @VisibleForTesting
    CloudDataSource cloudDataSource;
    @VisibleForTesting
    TestSubscriber<List<MovieReview>> testSubscriber;

    @Before
    public void beforeTest() {
        retrofitApi = MoviesRequestManager.getInstance();
        cloudDataSource = new CloudDataSource(retrofitApi, null);
        testSubscriber = TestSubscriber.create();
    }

    @Test
    public void restApiTest() {
        cloudDataSource.allReviews()
                .subscribe(testSubscriber);
        testSubscriber.awaitTerminalEvent();
        testSubscriber.assertNoErrors();
        final List<List<MovieReview>> nextEvents = testSubscriber.getOnNextEvents();
        Assert.assertFalse(nextEvents.isEmpty());

    }

    @After
    public void afterTest() {
        testSubscriber.unsubscribe();
    }



}
