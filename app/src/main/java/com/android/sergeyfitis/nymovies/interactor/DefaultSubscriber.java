package com.android.sergeyfitis.nymovies.interactor;

import rx.Subscriber;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public class DefaultSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
        // no-op by default.
    }

    @Override
    public void onError(Throwable e) {
        // no-op by default.
    }

    @Override
    public void onNext(T t) {
        // no-op by default.
    }
}
