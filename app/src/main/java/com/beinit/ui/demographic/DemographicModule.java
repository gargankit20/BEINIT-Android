package com.beinit.ui.demographic;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.beinit.bestpractices.R;
import com.beinit.ui.demographic.adapter.DemographicTitleAdapter;

import java.util.Arrays;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class DemographicModule {
    final FragmentManager mFragmentManager;
    final Context mContext;

    public DemographicModule(final Context mContext, final FragmentManager mFragmentManager) {
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
    }

    @Provides
    @DemographicScope
    DemographicTitleAdapter provideDemographicTitleAdapter() {
        final String[] mArray = mContext.getResources().getStringArray(R.array.demographic_title);
        final List<String> mData = Arrays.asList(mArray);
        return new DemographicTitleAdapter(mFragmentManager, mData);
    }
}
