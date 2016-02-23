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

    public PresenterImpl(ViewOps view, SearchInteractor interactor) {
        Log.i(TAG, "PresenterImpl: ");
        this.view = view;
        this.interactor = interactor;
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
     * @return query
     */
    @Override
    public String getQuery() {
        Log.i(TAG, "getQuery: " + query);
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
        interactor.subscribeToEditText(editText, this);
    }



    /**
     * Tell the View its time to update the map
     * @param latLng SearchInteractor return this value
     */
    @Override
    public void updateLocation(LatLng latLng) {
        Log.i(TAG, "updateLocation: ");
        view.showPropertyInMap(latLng);
    }

    /**
     * Receive the query from the Observer in SearchInteractor and keep in in a variable to
     * send it back to the click search button in SearchFragment
     * @param query
     */
    @Override
    public void getQueryFromObserver(CharSequence query) {
        this.query = query.toString();
    }

    @Override
    public void onDestroyView() {
        interactor.unsubscribe();
        ButterKnife.unbind(etSearch);
    }
}
