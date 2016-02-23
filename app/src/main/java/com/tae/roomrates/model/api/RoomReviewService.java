package com.tae.roomrates.model.api;

import com.tae.roomrates.Constants;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Eduardo on 20/02/2016.
 */
public interface RoomReviewService {
    @GET(Constants.ENDPOINT_URL) // add endpoint in constants
    Observable<Object> getLocation(); // TODO add the query param @Query("") String address
}
