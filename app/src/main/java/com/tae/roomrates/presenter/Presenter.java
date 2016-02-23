package com.tae.roomrates.presenter;

import android.widget.EditText;

import com.tae.roomrates.presenter.interactor.SearchInteractor;

/**
 * Created by Eduardo on 21/02/2016.
 */
public interface Presenter {

    void searchProperty(String query);

    String getQuery();

    void subscribeToQuery(EditText editText);


}
