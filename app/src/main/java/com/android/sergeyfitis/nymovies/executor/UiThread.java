package com.android.sergeyfitis.nymovies.executor;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public class UiThread implements PostExecutionThread {

    public static UiThread sInstance = new UiThread();

    private UiThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
