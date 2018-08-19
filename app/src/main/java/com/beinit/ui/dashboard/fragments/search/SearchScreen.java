package com.beinit.ui.dashboard.fragments.search;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.account.AccountFragment;
import com.common.base.navigation.FragmentScreen;

public class SearchScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new SearchFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
