package com.beinit.ui.dashboard.fragments.account.channels.blocked;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.account.channels.ChannelsFragment;
import com.common.base.navigation.FragmentScreen;

public class ChannelsBlockedScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new ChannelsBlockedFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
