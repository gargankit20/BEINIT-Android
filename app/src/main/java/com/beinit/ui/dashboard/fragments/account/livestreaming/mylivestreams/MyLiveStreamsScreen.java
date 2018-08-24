package com.beinit.ui.dashboard.fragments.account.livestreaming.mylivestreams;

import android.support.v4.app.Fragment;

import com.common.base.navigation.FragmentScreen;

public class MyLiveStreamsScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new MyLiveStreamsFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
