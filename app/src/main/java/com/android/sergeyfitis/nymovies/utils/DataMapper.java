package com.android.sergeyfitis.nymovies.utils;

import android.support.annotation.Nullable;

import com.android.sergeyfitis.nymovies.data.db.MovieLink;
import com.android.sergeyfitis.nymovies.data.db.MovieMultimedia;
import com.android.sergeyfitis.nymovies.data.db.MovieReview;
import com.android.sergeyfitis.nymovies.data.network.NetworkMovieLink;
import com.android.sergeyfitis.nymovies.data.network.NetworkMovieMultimedia;
import com.android.sergeyfitis.nymovies.data.network.NetworkMovieReview;

import java.util.List;

import io.realm.RealmList;

/**
 * Created by Serhii Yaremych on 29.02.2016.
 */
public class DataMapper {
    @Nullable
    public static MovieReview convertToMovieReview(@Nullable NetworkMovieReview movieReview) {
        if (movieReview == null) return null;
        MovieReview dbReview = new MovieReview();
        dbReview.setNytMovieId(movieReview.getNytMovieId());
        dbReview.setByline(movieReview.getByline());
        dbReview.setCriticsPick(movieReview.getCriticsPick());
        dbReview.setDateUpdated(movieReview.getDateUpdated());
        dbReview.setDvdReleaseDate(movieReview.getDvdReleaseDate());
        dbReview.setPublicationDate(movieReview.getPublicationDate());
        dbReview.setHeadline(movieReview.getHeadline());
        dbReview.setLink(convertToLink(movieReview.getLink()));
        dbReview.setDisplayTitle(movieReview.getDisplayTitle());
        dbReview.setMpaaRating(movieReview.getMpaaRating());
        dbReview.setMultimedia(convertToMultimedia(movieReview.getMultimedia()));
        dbReview.setOpeningDate(dbReview.getOpeningDate());
        dbReview.setRelatedUrls(convertToLinksList(movieReview.getRelatedUrls()));
        dbReview.setSeoName(movieReview.getSeoName());
        dbReview.setSortName(movieReview.getSortName());
        dbReview.setSummaryShort(movieReview.getSummaryShort());
        return dbReview;
    }

    @Nullable
    private static MovieLink convertToLink(@Nullable NetworkMovieLink networkMovieLink) {
        if (networkMovieLink == null) return null;
        MovieLink link = new MovieLink();
        link.setSuggestedLinkText(networkMovieLink.getSuggestedLinkText());
        link.setType(networkMovieLink.getSuggestedLinkText());
        link.setUrl(networkMovieLink.getUrl());
        return link;
    }

    @Nullable
    private static MovieMultimedia convertToMultimedia(@Nullable NetworkMovieMultimedia movieMultimedia) {
        if (movieMultimedia == null) return null;
        MovieMultimedia multimedia = new MovieMultimedia();
        multimedia.setType(movieMultimedia.getResource().getType());
        multimedia.setSrc(movieMultimedia.getResource().getSrc());
        return multimedia;
    }

    @Nullable
    private static RealmList<MovieLink> convertToLinksList(@Nullable List<NetworkMovieLink> movieLinks) {
        if (movieLinks == null) return null;
        RealmList<MovieLink> links = new RealmList<>();
        for (NetworkMovieLink movieLink : movieLinks) {
            MovieLink link = convertToLink(movieLink);
            if (link != null) {
                links.add(link);
            }
        }
        return links;
    }
}
