package com.beinit.ui.dashboard;

import android.content.Context;
import android.support.v7.widget.Toolbar;

import com.beinit.ui.dashboard.fragments.discover.fragments.adapter.ChannelAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class DashboardModule {

    private Toolbar mToolbar;
    private Context mContext;

    public DashboardModule(Context mContext, Toolbar mToolbar) {
        this.mContext = mContext;
        this.mToolbar = mToolbar;
    }

    @DashboardScope
    @Provides
    Context provideContext() {
        return this.mContext;
    }

    @DashboardScope
    @Provides
    Toolbar provideDashboardToolbar() {
        return this.mToolbar;
    }

    @DashboardScope
    @Provides
    ChannelAdapter provideChannelAdapter() {
        return new ChannelAdapter();
    }
}
