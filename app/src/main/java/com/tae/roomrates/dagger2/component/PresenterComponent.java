package com.tae.roomrates.dagger2.component;

import com.tae.roomrates.dagger2.component.module.GoogleApiModule;
import com.tae.roomrates.dagger2.component.module.PresenterModule;
import com.tae.roomrates.dagger2.component.module.SearchInteractorModule;
import com.tae.roomrates.dagger2.component.scope.FragmentScope;
import com.tae.roomrates.presenter.Presenter;
import com.tae.roomrates.presenter.PresenterImpl;
import com.tae.roomrates.presenter.interactor.Interactor;
import com.tae.roomrates.presenter.interactor.SearchInteractor;
import com.tae.roomrates.view.MainActivity;
import com.tae.roomrates.view.SearchFragment;
import com.tae.roomrates.view.base.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Eduardo on 20/02/2016.
 */
@FragmentScope
@Component(
        dependencies = AppComponent.class,
        modules = {
                PresenterModule.class,
                SearchInteractorModule.class,
                GoogleApiModule.class
        }
)
public interface PresenterComponent {

//    void inject(MainActivity activity);
//    void inject(BaseFragment fragment);
    void inject(SearchFragment fragment);

    PresenterImpl getPresenterImpl();
    Presenter getPresenter();
//    SearchInteractor getSearchInteractor();
}
