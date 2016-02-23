package com.tae.roomrates.presenter.interactor;

import android.util.Log;
import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewTextChangeEvent;
import com.tae.roomrates.model.api.RoomReviewService;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Eduardo on 21/02/2016.
 */
public class SearchInteractor {

    private static final String TAG = SearchInteractor.class.getSimpleName();
    private RoomReviewService roomReviewService;
    private Subscription subscription;

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
        if (roomReviewService != null) {
            Log.i(TAG, "searProperty: roomreviewService is init!");
        }
    }


    /**
     * RxSubscription to observe what happens with the EditText
     * @param editText
     */
    public void subscribeToEditText(EditText editText, Interactor interactor) {
        subscription = RxTextView.textChangeEvents(editText)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getEditTextObserver(interactor));
    }

    public void unsubscribe() {
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    private Observer<TextViewTextChangeEvent> getEditTextObserver(final Interactor interactor) {
        return new Observer<TextViewTextChangeEvent>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: Error getting user input", e);
            }

            @Override
            public void onNext(TextViewTextChangeEvent textViewTextChangeEvent) {
                Log.i(TAG, "onNext: query to search is: " + textViewTextChangeEvent.text());
                interactor.getQueryFromObserver(textViewTextChangeEvent.text());
            }
        };
    }
}
