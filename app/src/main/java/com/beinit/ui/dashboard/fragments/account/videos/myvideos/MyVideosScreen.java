package com.beinit.ui.dashboard.fragments.account.videos.myvideos;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.account.videos.VideosFragment;
import com.common.base.navigation.FragmentScreen;

public class MyVideosScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new MyVideosFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
