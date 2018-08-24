package com.beinit.ui.dashboard.fragments.account.settings;

import android.support.v4.app.Fragment;

import com.common.base.navigation.FragmentScreen;

public class SettingScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new SettingFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
