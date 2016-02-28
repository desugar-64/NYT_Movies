package com.android.sergeyfitis.nymovies.data.network;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by Serhii Yaremych on 28.02.2016.
 */
public class NetworkMovieReview {
    @SerializedName("nyt_movie_id")
    private int nytMovieId;
    @SerializedName("display_title")
    private String displayTitle;
    @SerializedName("sort_name")
    private String sortName;
    @SerializedName("mpaa_rating")
    private String mpaaRating;
    @SerializedName("critics_pick")
    private int criticsPick;
    private String byline;
    private String headline;
    @SerializedName("summary_short")
    private String summaryShort;
    @SerializedName("publication_date")
    private Date publicationDate;
    @SerializedName("opening_date")
    private Date openingDate;
    @SerializedName("dvd_release_date")
    private Date dvdReleaseDate;
    @SerializedName("date_updated")
    private Date dateUpdated;
    @SerializedName("seo_name")
    private String seoName;
    private NetworkMovieLink link;
    @SerializedName("related_urls")
    private List<NetworkMovieLink> relatedUrls;
    private NetworkMovieMultimedia multimedia;

    public int getNytMovieId() {
        return nytMovieId;
    }

    public void setNytMovieId(int nytMovieId) {
        this.nytMovieId = nytMovieId;
    }

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public int getCriticsPick() {
        return criticsPick;
    }

    public void setCriticsPick(int criticsPick) {
        this.criticsPick = criticsPick;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummaryShort() {
        return summaryShort;
    }

    public void setSummaryShort(String summaryShort) {
        this.summaryShort = summaryShort;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Date getDvdReleaseDate() {
        return dvdReleaseDate;
    }

    public void setDvdReleaseDate(Date dvdReleaseDate) {
        this.dvdReleaseDate = dvdReleaseDate;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getSeoName() {
        return seoName;
    }

    public void setSeoName(String seoName) {
        this.seoName = seoName;
    }

    public NetworkMovieLink getLink() {
        return link;
    }

    public void setLink(NetworkMovieLink link) {
        this.link = link;
    }

    public List<NetworkMovieLink> getRelatedUrls() {
        return relatedUrls;
    }

    public void setRelatedUrls(List<NetworkMovieLink> relatedUrls) {
        this.relatedUrls = relatedUrls;
    }

    public NetworkMovieMultimedia getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(NetworkMovieMultimedia multimedia) {
        this.multimedia = multimedia;
    }
}
