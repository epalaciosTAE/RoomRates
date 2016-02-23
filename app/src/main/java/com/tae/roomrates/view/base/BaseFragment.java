package com.tae.roomrates.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tae.roomrates.App;

import com.tae.roomrates.presenter.PresenterImpl;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Eduardo on 21/02/2016.
 */
public abstract class BaseFragment extends Fragment {

    private static final String TAG = BaseFragment.class.getSimpleName();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbindViews();
    }

    /**
     * Specify the xml layout of the child fragment to be inflated
     * */
    protected abstract int getFragmentLayout();

    /**
     * Init views with ButterKnife
     * */
    private void bindViews(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    /**
     * Unbind ButterKnife views
     */
    private void unbindViews() {
        ButterKnife.unbind(this);
    }

}
