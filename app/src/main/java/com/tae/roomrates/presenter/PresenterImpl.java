package com.tae.roomrates.presenter;

import android.util.Log;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;
import com.tae.roomrates.presenter.interactor.Interactor;
import com.tae.roomrates.presenter.interactor.SearchInteractor;
import com.tae.roomrates.view.ViewOps;
import com.tae.roomrates.view.base.BaseFragment;
import com.tae.roomrates.view.base.BasePresenter;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Eduardo on 21/02/2016.
 */
public class PresenterImpl extends BasePresenter implements Presenter, Interactor {

    private static final String TAG = PresenterImpl.class.getSimpleName();
    private ViewOps view;
//    private WeakReference<EditText> wrEtSearch;
    private EditText etSearch;
    private SearchInteractor interactor;
    private String query;

    public PresenterImpl(ViewOps view) {
        Log.i(TAG, "PresenterImpl: ");
        this.view = view;
//        this.interactor = interactor;
    }

    /**
     * Tell SearchInteractor to make a request for a search
     * @param query
     */
    @Override
    public void searchProperty(String query) {
        Log.i(TAG, "searchProperty: with query: " + query);
        //TODO search a location in Google Address
        interactor.searProperty(query, this);
    }

    /**
     * Return Result from Subscriber in interactor
     * @return
     */
    @Override
    public String getQuery() {
        Log.i(TAG, "getQuery: ");
        //TODO return value from interactor ops
        return query;
    }

    /**
     * Get user input from SearchFragment
     * @param editText user input
     */
    @Override
    public void subscribeToQuery(EditText editText) {
        //TODO interactor subscribe to observable
//        wrEtSearch = new WeakReference<EditText>(editText);
        etSearch = editText;
    }

    @Override
    public void setInteractor(SearchInteractor interactor) {
        this.interactor = interactor;
    }

    /**
     * Tell the View its time to update the map
     * @param latLng
     */
    @Override
    public void updateLocation(LatLng latLng) {
        Log.i(TAG, "updateLocation: ");
        view.showPropertyInMap(latLng);
    }

    @Override
    public void getQueryFromSubscriber(String query) {
        //TODO pass the query to SearchFragment to prepare the query when the user press button to search
        this.query = query;
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(etSearch);
    }
}
