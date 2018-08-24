package com.beinit.ui.dashboard.fragments.account.channels.followers;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.account.channels.ChannelsFragment;
import com.common.base.navigation.FragmentScreen;

public class ChannelsFollowersScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new ChannelsFollowersFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
