package com.tae.roomrates.model.api;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.tae.roomrates.constants.Constants;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Eduardo on 20/02/2016.
 */
public class ServerAdapter {

    private Retrofit retrofit;

    public ServerAdapter(OkHttpClient client, Gson gson) {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
