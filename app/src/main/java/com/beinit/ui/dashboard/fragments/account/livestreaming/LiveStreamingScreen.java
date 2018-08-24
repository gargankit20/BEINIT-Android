package com.beinit.ui.dashboard.fragments.account.livestreaming;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.account.settings.about.AboutFragment;
import com.common.base.navigation.FragmentScreen;

public class LiveStreamingScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new LiveStreamingFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
