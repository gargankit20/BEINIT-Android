package com.beinit.ui.dashboard.fragments.account.settings.account;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.account.MyAccountFragment;
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
