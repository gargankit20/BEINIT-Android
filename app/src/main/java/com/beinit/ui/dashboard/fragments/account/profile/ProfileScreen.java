package com.beinit.ui.dashboard.fragments.account.profile;

import android.support.v4.app.Fragment;

import com.common.base.navigation.FragmentScreen;

public class ProfileScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new ProfileFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
