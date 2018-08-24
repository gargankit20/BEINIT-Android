package com.beinit.ui.dashboard.fragments.account.settings.about;

import android.support.v4.app.Fragment;

import com.common.base.navigation.FragmentScreen;

public class AboutScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new AboutFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
