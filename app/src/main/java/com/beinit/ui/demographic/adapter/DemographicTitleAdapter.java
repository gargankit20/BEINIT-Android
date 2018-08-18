package com.beinit.ui.demographic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.beinit.ui.demographic.fragments.DemographicTitleScreen;
import com.common.base.widgets.adapter.SmartFragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class DemographicTitleAdapter extends SmartFragmentStatePagerAdapter {
    final List<String> mData = new ArrayList<>();

    public DemographicTitleAdapter(final FragmentManager fragmentManager, final List<String> mData) {
        super(fragmentManager);
        this.mData.addAll(mData);
    }

    @Override
    public Fragment getItem(final int position) {
        final String mTitle = mData.get(position);
        final DemographicTitleScreen mScreen = new DemographicTitleScreen(mTitle);
        return mScreen.getFragment();
    }

    @Override
    public int getCount() {
        return mData.size();
    }
}
