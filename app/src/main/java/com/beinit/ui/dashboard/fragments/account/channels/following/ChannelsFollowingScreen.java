package com.beinit.ui.dashboard.fragments.account.channels.following;

import android.support.v4.app.Fragment;

import com.common.base.navigation.FragmentScreen;

public class ChannelsFollowingScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new ChannelsFollowingFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
