package com.beinit.ui.dashboard.fragments.account.profile.followers;

import android.support.v4.app.Fragment;

import com.common.base.navigation.FragmentScreen;

public class FollowersScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new FollowersFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
