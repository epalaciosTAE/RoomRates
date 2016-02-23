package com.tae.roomrates.view;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Eduardo on 20/02/2016.
 * View layout in model
 */
public interface ViewOps {
    /**
     * Get parameter from Presenter
     */
    void showPropertyInMap(LatLng latLng); // TODO add LatLong parameter
}
