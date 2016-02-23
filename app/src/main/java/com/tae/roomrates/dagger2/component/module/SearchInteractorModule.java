package com.tae.roomrates.dagger2.component.module;

import android.util.Log;

import com.tae.roomrates.dagger2.component.scope.FragmentScope;
import com.tae.roomrates.model.api.RoomReviewService;
import com.tae.roomrates.presenter.interactor.SearchInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eduardo on 22/02/2016.
 */
@Module
public class SearchInteractorModule {

    private static final String TAG = SearchInteractorModule.class.getSimpleName();

    @Provides @FragmentScope
    public SearchInteractor provideInteractor(RoomReviewService service) {
        Log.i(TAG, "provideInteractor: ");
        return new SearchInteractor(service);
    }
}
