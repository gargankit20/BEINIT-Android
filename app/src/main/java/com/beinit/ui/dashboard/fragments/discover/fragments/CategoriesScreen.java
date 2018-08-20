package com.beinit.ui.dashboard.fragments.discover.fragments;

import android.support.v4.app.Fragment;

import com.common.base.navigation.FragmentScreen;

public class CategoriesScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new CategoriesFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
