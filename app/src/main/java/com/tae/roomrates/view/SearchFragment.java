package com.tae.roomrates.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.tae.roomrates.App;
import com.tae.roomrates.Injector;
import com.tae.roomrates.R;

import com.tae.roomrates.dagger2.component.DaggerPresenterComponent;
import com.tae.roomrates.dagger2.component.module.GoogleApiModule;
import com.tae.roomrates.dagger2.component.module.PresenterModule;
import com.tae.roomrates.dagger2.component.module.SearchInteractorModule;
import com.tae.roomrates.model.api.RoomReviewService;
import com.tae.roomrates.presenter.Presenter;
import com.tae.roomrates.presenter.PresenterImpl;
import com.tae.roomrates.presenter.interactor.SearchInteractor;
import com.tae.roomrates.view.base.BaseFragment;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * Created by Eduardo on 20/02/2016.
 * Map fragment where user will look for properties
 */
public class SearchFragment extends BaseFragment
        implements OnMapReadyCallback, GoogleApiClient.OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks, ViewOps {

    public static final String TAG = SearchFragment.class.getSimpleName();
    private GoogleMap map;

    @Bind(R.id.et_query_search)
    EditText etSearch;

    @Inject
    Presenter presenter;
    @Inject
    GoogleApiClient mGoogleApiClient;


    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        // TODO refactor to Intector.class
//        DaggerPresenterComponent.builder()
//                .appComponent(App.getApp(getActivity().getApplicationContext()).getAppComponent())
//                .presenterModule(new PresenterModule(this))
//                .searchInteractorModule(new SearchInteractorModule(App.getApp(getActivity().getApplicationContext()).getNetWorkComponent().getRoomReviewService()))
//                .googleApiModule(new GoogleApiModule(this, this))
//                .build().inject(this);
        Injector.injectPresenterComponent( // TODO make injector a singleton
                App.getApp(getActivity().getApplicationContext()).getAppComponent(),
                this,
                App.getApp(getActivity().getApplicationContext()).getNetWorkComponent().getRoomReviewService(),
                this,
                this
                ).inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: subscribe to query");
//        presenter.setInteractor(interactor);
        presenter.subscribeToQuery(etSearch);
    }


    @Override
    public void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }


    @Override
    public void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    @OnClick(R.id.tbn_search)
    public void onClick(View view) {
        Log.i(TAG, "onClick: init search with query: " + presenter.getQuery());
        //TODO start search
        presenter.searchProperty(presenter.getQuery());
    }

//    @OnTextChanged(R.id.et_query_search)
//    public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//    }


        @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_search;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    /**
     * Update map location with a marker when Presenter returns the value
     */
    @Override
    public void showPropertyInMap(LatLng latLng) {
        Log.i(TAG, "showPropertyInMap: ");
    }
}
