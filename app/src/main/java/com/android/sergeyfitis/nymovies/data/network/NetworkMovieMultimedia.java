package com.android.sergeyfitis.nymovies.data.network;

/**
 * Created by Serhii Yaremych on 28.02.2016.
 */
public class NetworkMovieMultimedia {
    private Resource resource;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    static class Resource {
        private String type;
        private String src;

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
}
