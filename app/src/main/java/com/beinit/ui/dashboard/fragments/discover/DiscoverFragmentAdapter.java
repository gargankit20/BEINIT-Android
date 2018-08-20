package com.beinit.ui.dashboard.fragments.discover;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.beinit.R;
import com.beinit.ui.dashboard.fragments.discover.fragments.CategoriesScreen;
import com.beinit.ui.dashboard.fragments.discover.fragments.ChannelScreen;
import com.common.base.widgets.adapter.SmartFragmentStatePagerAdapter;

public class DiscoverFragmentAdapter extends SmartFragmentStatePagerAdapter {
    final String[] titles;

    public DiscoverFragmentAdapter(final Context mContext, final FragmentManager fragmentManager) {
        super(fragmentManager);
        titles = mContext.getResources().getStringArray(R.array.discover_title);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ChannelScreen().getFragment();
            case 1:
                return new CategoriesScreen().getFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
