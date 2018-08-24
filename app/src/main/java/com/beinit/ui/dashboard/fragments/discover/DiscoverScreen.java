package com.beinit.ui.dashboard.fragments.discover;

import android.support.v4.app.Fragment;

import com.common.base.navigation.FragmentScreen;

public class DiscoverScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new DiscoverFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
