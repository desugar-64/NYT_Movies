package com.android.sergeyfitis.nymovies.executor;

import rx.Scheduler;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}
