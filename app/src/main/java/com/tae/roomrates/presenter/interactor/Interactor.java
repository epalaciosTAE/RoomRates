package com.tae.roomrates.presenter.interactor;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Eduardo on 21/02/2016.
 */
public interface Interactor {

    void updateLocation(LatLng latLng);

    void getQueryFromSubscriber(String query);
}
