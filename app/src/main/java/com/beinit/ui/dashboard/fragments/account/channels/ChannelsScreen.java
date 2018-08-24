package com.beinit.ui.dashboard.fragments.account.channels;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.account.livestreaming.LiveStreamingFragment;
import com.common.base.navigation.FragmentScreen;

public class ChannelsScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new ChannelsFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
