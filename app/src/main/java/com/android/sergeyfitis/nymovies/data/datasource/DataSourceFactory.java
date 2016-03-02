package com.android.sergeyfitis.nymovies.data.datasource;

import com.android.sergeyfitis.nymovies.data.MoviesRequestManager;

import java.util.concurrent.TimeUnit;

/**
 * Created by Serhii Yaremych on 02.03.2016.
 */
public class DataSourceFactory {

    private static long lastTimeSync = 0L;
    private static final long TIME_SYNC_INTERVAL = TimeUnit.SECONDS.toMillis(20);


    public static MovieReviewDataSource create(DbManager dbManager) {
        boolean isDataOutdated = System.currentTimeMillis() - lastTimeSync >= TIME_SYNC_INTERVAL;
        MovieReviewDataSource source;

        if (isDataOutdated) {
            source = new CloudDataSource(MoviesRequestManager.getInstance(), dbManager);
            lastTimeSync = System.currentTimeMillis();
        } else {
            source = new LocalDataSource(dbManager);
        }

        return source;
    }
}
