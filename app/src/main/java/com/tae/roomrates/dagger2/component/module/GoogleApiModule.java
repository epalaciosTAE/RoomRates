package com.tae.roomrates.dagger2.component.module;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;
import com.tae.roomrates.dagger2.component.scope.FragmentScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eduardo on 21/02/2016.
 */

@Module
public class GoogleApiModule {

    private static final String TAG = GoogleApiModule.class.getSimpleName();
     GoogleApiClient.OnConnectionFailedListener failedListener;
     GoogleApiClient.ConnectionCallbacks connectionCallbacks;

    public GoogleApiModule(GoogleApiClient.OnConnectionFailedListener failedListener, GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Log.i(TAG, "GoogleApiModule: Constructor");
        this.failedListener = failedListener;
        this.connectionCallbacks = connectionCallbacks;
    }

    @Provides @FragmentScope
    public GoogleApiClient.OnConnectionFailedListener provideConnectionFailedListener() {
        Log.i(TAG, "provideConnectionFailedListener: ");
        return failedListener;
    }


    @Provides @FragmentScope
    public GoogleApiClient.ConnectionCallbacks provideConnectionCallbacks() {
        Log.i(TAG, "provideConnectionCallbacks: ");
        return connectionCallbacks;
    }

    @Provides @FragmentScope
    public GoogleApiClient provideGoogleApiClient(
            Context context,
            GoogleApiClient.OnConnectionFailedListener failedListener,
            GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Log.i(TAG, "provideGoogleApiClient: ");
        return new GoogleApiClient
                .Builder(context)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .addConnectionCallbacks(connectionCallbacks)
                .addOnConnectionFailedListener(failedListener)
                .build();
    }
}
