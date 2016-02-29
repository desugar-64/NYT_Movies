package com.android.sergeyfitis.nymovies.data;

import com.android.sergeyfitis.nymovies.data.network.C;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Serhii Yaremych on 28.02.2016.
 */
public class MoviesRequestManager {
    private static MoviesReviewsRetrofitApi sInstance;

    public static MoviesReviewsRetrofitApi getInstance() {
        if (sInstance == null) {
            final Interceptor requestsInterceptor = chain -> {
                Request request = chain.request().newBuilder()
                        .url(chain.request().url() + "?" + C.API_KEY)
                        .build();
                return chain.proceed(request);
            };
            final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(requestsInterceptor)
                    .addInterceptor(loggingInterceptor)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(C.BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setDateFormat("yyyy-mm-dd").create()))
                    .client(okHttpClient)
                    .build();
            sInstance = retrofit.create(MoviesReviewsRetrofitApi.class);
        }

        return sInstance;
    }

    private MoviesRequestManager() {
    }
}
