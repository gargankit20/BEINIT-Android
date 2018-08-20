package com.beinit.ui.dashboard.fragments.discover.fragments;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.discover.DiscoverFragment;
import com.common.base.navigation.FragmentScreen;

public class ChannelScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new ChannelFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
