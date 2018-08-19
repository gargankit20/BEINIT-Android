package com.beinit.ui.dashboard.fragments.account;

import android.support.v4.app.Fragment;

import com.common.base.navigation.FragmentScreen;

public class AccountScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new AccountFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
