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
 * TODO Create graph object for networkmodule
 * TODO Create method to pass the networkComponent
 */
public class App extends Application {

    private static final String TAG = App.class.getSimpleName();
    private AppComponent appComponent;

    public static App getApp(Context context) {
        return ((App) context.getApplicationContext());
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        NetWorkComponent netWorkComponent = DaggerNetWorkComponent.builder()
                .netWorkModule(new NetWorkModule())
//                .searchInteractorModule(new SearchInteractorModule())
                .build();

        appComponent = DaggerAppComponent.builder()
                .netWorkComponent(netWorkComponent)
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }



}
