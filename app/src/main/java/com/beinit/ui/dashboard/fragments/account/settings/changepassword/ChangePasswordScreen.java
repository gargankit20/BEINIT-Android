package com.beinit.ui.dashboard.fragments.account.settings.changepassword;

import android.support.v4.app.Fragment;

import com.common.base.navigation.FragmentScreen;

public class ChangePasswordScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new ChangePasswordFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
