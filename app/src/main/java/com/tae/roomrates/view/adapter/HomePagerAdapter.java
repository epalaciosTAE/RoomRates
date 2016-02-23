package com.tae.roomrates.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tae.roomrates.view.PropertiesFragment;
import com.tae.roomrates.view.SearchFragment;

/**
 * Created by Eduardo on 20/02/2016.
 * Adapter to display:
 * @see {@link com.tae.roomrates.view.SearchFragment}
 * @see {@link com.tae.roomrates.view.PropertiesFragment}
 */
public class HomePagerAdapter extends FragmentPagerAdapter {

    public static final String[] TITLES = {"Search in Map", "View all"};

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        return position == 0 ? SearchFragment.newInstance()
                : PropertiesFragment.newInstance();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  position == 0 ? TITLES[0] : TITLES[1];

    }

    @Override
    public int getCount() {
        return TITLES.length;
    }
}
