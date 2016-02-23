package com.tae.roomrates.dagger2.component.module;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.tae.roomrates.App;
import com.tae.roomrates.Constants;
import com.tae.roomrates.dagger2.component.scope.ApplicationScope;
import com.tae.roomrates.dagger2.component.scope.FragmentScope;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eduardo on 20/02/2016.
 */
@Module
public class AppModule {

    private static final String TAG = AppModule.class.getSimpleName();
    private App application;

    public AppModule(App application) {
        Log.i(TAG, "AppModule: Constructor");
        this.application = application;
    }

    @Provides @ApplicationScope
    public Context provideContext() {
        Log.i(TAG, "provideContext: ");
        return application.getApplicationContext();
    }

    @Provides @ApplicationScope
    public App provideApplication() {
        Log.i(TAG, "provideApplication: ");
        return application;
    }

}
