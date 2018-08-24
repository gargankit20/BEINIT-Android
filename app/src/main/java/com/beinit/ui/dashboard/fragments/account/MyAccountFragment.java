package com.beinit.ui.dashboard.fragments.account;


import com.beinit.R;
import com.beinit.base.AppBaseFragment;
import com.beinit.ui.dashboard.DashboardComponent;
import com.beinit.ui.dashboard.fragments.account.channels.ChannelsScreen;
import com.beinit.ui.dashboard.fragments.account.livestreaming.LiveStreamingScreen;
import com.beinit.ui.dashboard.fragments.account.profile.ProfileScreen;
import com.beinit.ui.dashboard.fragments.account.settings.SettingScreen;
import com.beinit.ui.dashboard.fragments.account.videos.VideosScreen;
import com.common.base.navigation.FragmentScreenSwitcher;
import com.common.base.navigation.HasComponent;

import javax.inject.Inject;

import butterknife.OnClick;


public class MyAccountFragment extends AppBaseFragment {

    @Inject
    FragmentScreenSwitcher mFragmentScreenSwitcher;


    @Override
    protected int layoutId() {
        return R.layout.fragment_my_account;
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

    @OnClick(R.id.setting_image_view)
    public void onSettingImageViewClicked() {
        mFragmentScreenSwitcher.open(new SettingScreen());
    }

    @OnClick(R.id.profile_image_view)
    public void onProfileImageViewClicked() {
        mFragmentScreenSwitcher.open(new ProfileScreen());
    }

    @OnClick(R.id.live_right_to_image_view)
    public void onLiveRightToImageViewClicked() {
        mFragmentScreenSwitcher.open(new LiveStreamingScreen());
    }

    @OnClick(R.id.video_right_to_image_view)
    public void onVideoRightToImageViewClicked() {
        mFragmentScreenSwitcher.open(new VideosScreen());
    }

    @OnClick(R.id.channels_right_to_image_view)
    public void onChannelsRightToImageViewClicked() {
        mFragmentScreenSwitcher.open(new ChannelsScreen());
    }
}
