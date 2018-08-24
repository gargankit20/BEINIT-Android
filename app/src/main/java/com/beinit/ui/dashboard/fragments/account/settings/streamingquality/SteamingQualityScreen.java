package com.beinit.ui.dashboard.fragments.account.settings.streamingquality;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.account.settings.SettingFragment;
import com.common.base.navigation.FragmentScreen;

public class SteamingQualityScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new StreamingQualityFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
