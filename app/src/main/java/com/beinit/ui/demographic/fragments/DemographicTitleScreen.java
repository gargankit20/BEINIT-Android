package com.beinit.ui.demographic.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.beinit.ui.demographic.model.DemographicModel;
import com.common.base.navigation.FragmentScreen;

public class DemographicTitleScreen extends FragmentScreen {

    private final DemographicModel mModel;
    public static final String TITLE = "DemographicTitleScreen.title";

    public DemographicTitleScreen(final DemographicModel mModel) {
        super();
        this.mModel = mModel;
    }

    @Override
    protected Fragment createFragment() {
        return new DemographicTitleFragment();
    }

    @Override
    protected void onAddArguments(Bundle mArguments) {
        super.onAddArguments(mArguments);
        mArguments.putParcelable(TITLE, mModel);
    }

    @Override
    protected String getName() {
        return getClass().getName();
    }
}
