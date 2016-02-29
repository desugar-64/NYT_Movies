package com.android.sergeyfitis.nymovies.data.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Serhii Yaremych on 28.02.2016.
 */
public class MovieMultimedia extends RealmObject {

    @PrimaryKey
    private String src;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
