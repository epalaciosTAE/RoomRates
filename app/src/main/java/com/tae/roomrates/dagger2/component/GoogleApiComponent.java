package com.tae.roomrates.dagger2.component;

import com.google.android.gms.common.api.GoogleApiClient;
import com.tae.roomrates.dagger2.component.module.AppModule;
import com.tae.roomrates.dagger2.component.module.GoogleApiModule;
import com.tae.roomrates.view.MainActivity;
import com.tae.roomrates.view.SearchFragment;
import com.tae.roomrates.view.base.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Eduardo on 21/02/2016.
 */
//@Singleton
//@Component (
//        modules = {
//                GoogleApiModule.class,
//                AppModule.class
//        }
//)
public interface GoogleApiComponent {

//    void inject(MainActivity activity);
////    void inject(BaseFragment fragment);
////    void inject(SearchFragment fragment);
//    GoogleApiClient provideGoogleApiClient();
//

}
