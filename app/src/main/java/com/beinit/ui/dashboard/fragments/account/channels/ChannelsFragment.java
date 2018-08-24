package com.beinit.ui.dashboard.fragments.account.channels;


import com.beinit.R;
import com.beinit.base.AppBaseFragment;
import com.beinit.ui.dashboard.DashboardComponent;
import com.beinit.ui.dashboard.fragments.account.channels.blocked.ChannelsBlockedScreen;
import com.beinit.ui.dashboard.fragments.account.channels.followers.ChannelsFollowersScreen;
import com.beinit.ui.dashboard.fragments.account.channels.following.ChannelsFollowingScreen;
import com.common.base.navigation.FragmentScreenSwitcher;
import com.common.base.navigation.HasComponent;

import javax.inject.Inject;

import butterknife.OnClick;


public class ChannelsFragment extends AppBaseFragment {

    @Inject
    FragmentScreenSwitcher mFragmentScreenSwitcher;

    @Override
    protected int layoutId() {
        return R.layout.fragment_channels;
    }

    @Override
    protected void injectToActivityComponent() {
        final DashboardComponent mComponent =
                ((HasComponent<DashboardComponent>) getActivity()).getComponent();
        mComponent.inject(this);
    }

    @Override
    public void onShow() {

    }

    @OnClick(R.id.back_image_view)
    public void onViewClicked() {
        mFragmentScreenSwitcher.goBack();
    }


    @OnClick(R.id.following_right_to_image_view)
    public void onFollowingRightToImageViewClicked() {
        mFragmentScreenSwitcher.open(new ChannelsFollowingScreen());
    }

    @OnClick(R.id.followers_right_to_image_view)
    public void onFollowersRightToImageViewClicked() {
        mFragmentScreenSwitcher.open(new ChannelsFollowersScreen());
    }

    @OnClick(R.id.blocked_right_to_image_view)
    public void onBlockedRightToImageViewClicked() {
        mFragmentScreenSwitcher.open(new ChannelsBlockedScreen());
    }
}
