package com.tae.roomrates.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tae.roomrates.R;
import com.tae.roomrates.view.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by Eduardo on 20/02/2016.
 * List with all properties
 */
public class PropertiesFragment extends BaseFragment {

    public static final String TAG = PropertiesFragment.class.getSimpleName();

    public static PropertiesFragment newInstance() {
        return new PropertiesFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_proterties;
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_proterties, container, false);
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        ButterKnife.bind(this, view);
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
