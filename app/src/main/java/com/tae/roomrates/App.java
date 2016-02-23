package com.tae.roomrates;

import android.app.Application;
import android.content.Context;


import com.tae.roomrates.dagger2.component.AppComponent;
import com.tae.roomrates.dagger2.component.DaggerAppComponent;
import com.tae.roomrates.dagger2.component.DaggerNetWorkComponent;
import com.tae.roomrates.dagger2.component.NetWorkComponent;
import com.tae.roomrates.dagger2.component.module.AppModule;
import com.tae.roomrates.dagger2.component.module.NetWorkModule;
import com.tae.roomrates.dagger2.component.module.SearchInteractorModule;


/**
 * Created by Eduardo on 20/02/2016.
 */
public class App extends Application {

    private static final String TAG = App.class.getSimpleName();
    private AppComponent appComponent;
    private NetWorkComponent netWorkComponent;

    public static App getApp(Context context) {
        return ((App) context.getApplicationContext());
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        netWorkComponent = Injector.injectNetworkComponent();
        appComponent = Injector.injectAppComponent(this, netWorkComponent);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public NetWorkComponent getNetWorkComponent() {
        return netWorkComponent;
    }



}
