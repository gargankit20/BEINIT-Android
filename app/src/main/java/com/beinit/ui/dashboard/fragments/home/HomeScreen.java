package com.beinit.ui.dashboard.fragments.home;

import android.support.v4.app.Fragment;

import com.common.base.navigation.FragmentScreen;

public class HomeScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new HomeFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
