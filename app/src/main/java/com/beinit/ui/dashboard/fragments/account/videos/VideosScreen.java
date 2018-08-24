package com.beinit.ui.dashboard.fragments.account.videos;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.account.livestreaming.LiveStreamingFragment;
import com.common.base.navigation.FragmentScreen;

public class VideosScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new VideosFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
