package com.beinit.ui.dashboard.fragments.account.videos.favourites;

import android.support.v4.app.Fragment;

import com.beinit.ui.dashboard.fragments.account.videos.VideosFragment;
import com.common.base.navigation.FragmentScreen;

public class FavouritesVideosScreen extends FragmentScreen {
    @Override
    protected Fragment createFragment() {
        return new FavouritesVideosFragment();
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
