package com.tae.roomrates.dagger2.component.module;

import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.tae.roomrates.Constants;
import com.tae.roomrates.model.api.RoomReviewService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Eduardo on 20/02/2016.
 */
@Module
public class NetWorkModule {

    private static final String TAG = NetWorkModule.class.getSimpleName();

    public NetWorkModule() {
        Log.i(TAG, "NetworkModule: Constructor");
    }

    /**
     * Instance of the Retrofit's interface that will connect with the API
     * @param retrofit
     * @return
     */
    @Provides @Singleton
    public RoomReviewService providesRoomReviewService(Retrofit retrofit) {
        Log.i(TAG, "providesRoomReviewService: ");
        return retrofit.create(RoomReviewService.class);
    }

    /**
     * In order to create the Retrofit object we need:
     * -Gson
     * -OkHttpCLient
     * -RxCallAdapter
     * @param client
     * @param gson
     * @return
     */
    @Provides @Singleton
    public Retrofit providesRetrofit(OkHttpClient client, Gson gson) {
        Log.i(TAG, "providesRetrotit: ");
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
//        return ItunesApiAdapter.getInstance();
    }

    /**
     * Use GsonBuilder to create the Gson Object
     * This is a simple one
     * @return
     */
    @Provides @Singleton
    public Gson providesGson() {
        Log.i(TAG, "providesGson: ");
        GsonBuilder builder = new GsonBuilder();
        builder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return builder.create();
    }

    /**
     * Simple OkHttpClient with logging interceptor
     * @param interceptor
     * @return
     */
    @Provides @Singleton
    public OkHttpClient providesOkHttpClient(HttpLoggingInterceptor interceptor) {
        Log.i(TAG, "providesOkHttpClient: ");
        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(interceptor);
        return client;
    }

    /**
     * Interceptor object to log the body of the JSON
     * We can log the Headers, etc
     * @return
     */
    @Provides @Singleton
    public HttpLoggingInterceptor providesInterceptor() {
        Log.i(TAG, "providesInterceptor: ");
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}
