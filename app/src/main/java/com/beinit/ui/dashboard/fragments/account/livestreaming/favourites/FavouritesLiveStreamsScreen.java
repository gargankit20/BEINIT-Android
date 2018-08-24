package com.beinit.ui.dashboard.fragments.account.livestreaming.favourites;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.account.livestreaming.LiveStreamingFragment;
import com.common.base.navigation.FragmentScreen;

public class FavouritesLiveStreamsScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new FavouritesLiveStreamsFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
