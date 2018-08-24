package com.beinit.ui.dashboard.fragments.account.profile.videos;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.account.profile.ProfileFragment;
import com.common.base.navigation.FragmentScreen;

public class VedioScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new VideoFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
