package com.android.sergeyfitis.nymovies.data.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Serhii Yaremych on 28.02.2016.
 */
public class NetworkMovieReviewsResult {
    private String status;
    @SerializedName("num_results")
    private int numResults;
    private List<NetworkMovieReview> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }

    public List<NetworkMovieReview> getResults() {
        return results;
    }

    public void setResults(List<NetworkMovieReview> results) {
        this.results = results;
    }
}
