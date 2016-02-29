package com.android.sergeyfitis.nymovies.data.datasource;

import com.android.sergeyfitis.nymovies.data.db.DbFields;
import com.android.sergeyfitis.nymovies.data.db.MovieReview;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import rx.Observable;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public class DbManagerImpl implements DbManager {
    @Override
    public void saveMovieReviews(List<MovieReview> movieReviews) {
        Realm.getDefaultInstance()
                .executeTransaction(realm -> {
                    realm.copyToRealmOrUpdate(movieReviews);
                });
    }

    @Override
    public Observable<List<MovieReview>> allReviews() {
        return Realm.getDefaultInstance()
                .where(MovieReview.class)
                .findAllAsync()
                .asObservable()
                .filter(RealmResults::isLoaded)
                .map(list -> Realm.getDefaultInstance().copyFromRealm(list))
                .map(list -> list.subList(0, list.size() - 1));
    }

    @Override
    public Observable<MovieReview> movieReview(int reviewId) {
        return Realm.getDefaultInstance()
                .where(MovieReview.class)
                .equalTo(DbFields._MOVIE_REVIEW_ID, reviewId)
                .findFirstAsync()
                .asObservable()
                .filter(RealmObject::isLoaded)
                .map(review -> Realm.getDefaultInstance().copyFromRealm((MovieReview) review));
    }
}
