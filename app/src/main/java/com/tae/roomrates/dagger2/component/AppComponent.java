package com.tae.roomrates.dagger2.component;

import android.app.Application;
import android.content.Context;

import com.tae.roomrates.App;
import com.tae.roomrates.dagger2.component.module.AppModule;
import com.tae.roomrates.dagger2.component.scope.ApplicationScope;
import com.tae.roomrates.model.api.RoomReviewService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Eduardo on 20/02/2016.
 *
 */
@ApplicationScope
@Component(
        dependencies = NetWorkComponent.class,
        modules = AppModule.class
)
public interface AppComponent {

    App getApplication();
    Context getContext();
}
