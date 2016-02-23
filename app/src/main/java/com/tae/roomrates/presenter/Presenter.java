package com.tae.roomrates.presenter;

import android.widget.EditText;

import com.tae.roomrates.Constants;
import com.tae.roomrates.presenter.interactor.SearchInteractor;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Eduardo on 21/02/2016.
 */
public interface Presenter {

    void searchProperty(String query);

    String getQuery();

    void subscribeToQuery(EditText editText);

    void setInteractor(SearchInteractor interactor);
}
