package com.tae.roomrates.presenter.interactor;

import android.util.Log;

import com.tae.roomrates.model.api.RoomReviewService;

import javax.inject.Inject;

/**
 * Created by Eduardo on 21/02/2016.
 */
public class SearchInteractor {

    private static final String TAG = SearchInteractor.class.getSimpleName();
    private RoomReviewService roomReviewService;


    public SearchInteractor(RoomReviewService roomReviewService) {
        Log.i(TAG, "SearchInteractor: ");
        this.roomReviewService = roomReviewService;
    }

    /**
     * Request a property in server
     * RxJava to retrieve data
     * @param query
     * @param interactor
     */
    public void searProperty(String query, Interactor interactor) {
        Log.i(TAG, "searProperty: ");
        // TODO implement oberver to retrieve the data
    }




}
