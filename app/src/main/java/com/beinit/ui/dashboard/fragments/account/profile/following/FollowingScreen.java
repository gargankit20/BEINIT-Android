package com.beinit.ui.dashboard.fragments.account.profile.following;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.account.profile.videos.VideoFragment;
import com.common.base.navigation.FragmentScreen;

public class FollowingScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new FollowingFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
