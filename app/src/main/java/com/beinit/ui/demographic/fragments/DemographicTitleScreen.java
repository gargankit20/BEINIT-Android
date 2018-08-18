package com.beinit.ui.demographic.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.common.base.navigation.FragmentScreen;

public class DemographicTitleScreen extends FragmentScreen {

    private final String mTitle;
    public static final String TITLE = "DemographicTitleScreen.title";

    public DemographicTitleScreen(final String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    protected Fragment createFragment() {
        return new DemographicTitleFragment();
    }

    @Override
    protected void onAddArguments(Bundle mArguments) {
        super.onAddArguments(mArguments);
        mArguments.putString(TITLE, mTitle);
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
