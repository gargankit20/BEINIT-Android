package com.beinit.ui.dashboard.fragments.account;

import android.support.v4.app.Fragment;

import com.common.base.navigation.FragmentScreen;

public class MyAccountScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new MyAccountFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
