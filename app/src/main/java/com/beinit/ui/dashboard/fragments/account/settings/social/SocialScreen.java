package com.beinit.ui.dashboard.fragments.account.settings.social;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.account.settings.SettingFragment;
import com.common.base.navigation.FragmentScreen;

public class SocialScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new SocialFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
