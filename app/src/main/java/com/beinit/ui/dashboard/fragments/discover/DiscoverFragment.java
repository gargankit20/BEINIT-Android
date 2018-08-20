package com.beinit.ui.dashboard.fragments.discover;


import android.support.design.widget.TabLayout;

import com.beinit.R;
import com.beinit.base.AppBaseFragment;
import com.beinit.widget.LockableViewPager;

import butterknife.BindView;

public class DiscoverFragment extends AppBaseFragment {
    @BindView(R.id.view_pager)
    LockableViewPager mViewPager;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @Override
    protected int layoutId() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void injectToActivityComponent() {

    }

    @Override
    public void onStart() {
        super.onStart();
        final DiscoverFragmentAdapter mAdapter =
                new DiscoverFragmentAdapter(getContext(), getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setSwipeable(false);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onShow() {

    }
}
