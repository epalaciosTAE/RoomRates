package com.tae.roomrates.dagger2.component;

import com.tae.roomrates.dagger2.component.module.NetWorkModule;
import com.tae.roomrates.model.api.RoomReviewService;
import com.tae.roomrates.view.MainActivity;
import com.tae.roomrates.view.SearchFragment;
import com.tae.roomrates.view.base.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;
import retrofit.Retrofit;

/**
 * Created by Eduardo on 20/02/2016.
 */
@Singleton
@Component (
        modules = {
                NetWorkModule.class,
        }

)
public interface NetWorkComponent {

//        void inject(MainActivity activity);
//        void inject(BaseFragment fragment);
//        void inject(SearchFragment fragment);

        RoomReviewService getRoomReviewService();
}
