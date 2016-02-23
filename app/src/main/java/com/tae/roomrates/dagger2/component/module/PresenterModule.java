package com.tae.roomrates.dagger2.component.module;

import android.util.Log;

import com.tae.roomrates.dagger2.component.scope.FragmentScope;
import com.tae.roomrates.presenter.Presenter;
import com.tae.roomrates.presenter.PresenterImpl;
import com.tae.roomrates.presenter.interactor.SearchInteractor;
import com.tae.roomrates.view.ViewOps;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eduardo on 20/02/2016.
 */
@Module
public class PresenterModule {

    private static final String TAG = PresenterModule.class.getSimpleName();
    private ViewOps view;


    public PresenterModule(ViewOps view) {
        Log.i(TAG, "PresenterModule: Constructor");
        this.view = view;
    }

    @Provides @FragmentScope
    public ViewOps provideViewOps() {
        Log.i(TAG, "provideViewOps: ");
        return view;
    }

    @Provides @FragmentScope
    public PresenterImpl providePresenterImpl(ViewOps view) {
        Log.i(TAG, "providePresenterImpl: ");
        return new PresenterImpl(view);
    }

    @Provides @FragmentScope
    public Presenter providePresenter(PresenterImpl presenterImpl) {
        Log.i(TAG, "providePresenter: ");
        return presenterImpl;
    }

}
