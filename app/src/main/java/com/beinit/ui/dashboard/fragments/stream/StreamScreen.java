package com.beinit.ui.dashboard.fragments.stream;

import android.support.v4.app.Fragment;

import com.common.base.navigation.FragmentScreen;

public class StreamScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new StreamFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
