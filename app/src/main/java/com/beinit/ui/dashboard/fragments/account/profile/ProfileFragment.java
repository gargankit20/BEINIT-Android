package com.beinit.ui.dashboard.fragments.account.profile;

import android.support.v4.app.FragmentManager;

import com.beinit.R;
import com.beinit.base.AppBaseFragment;
import com.beinit.ui.dashboard.DashboardComponent;
import com.beinit.ui.dashboard.fragments.account.profile.followers.FollowersScreen;
import com.beinit.ui.dashboard.fragments.account.profile.following.FollowingScreen;
import com.beinit.ui.dashboard.fragments.account.profile.videos.VedioScreen;
import com.common.base.navigation.FragmentScreen;
import com.common.base.navigation.FragmentScreenSwitcher;
import com.common.base.navigation.HasComponent;

import javax.inject.Inject;

import butterknife.OnClick;

public class ProfileFragment extends AppBaseFragment {

    @Inject
    FragmentScreenSwitcher mFragmentScreenSwitcher;

    @Override
    protected int layoutId() {
        return R.layout.fragment_profile;
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

    @Override
    public void onStart() {
        super.onStart();
        setFragments(new VedioScreen());
    }

    @OnClick(R.id.back_image_view)
    public void onBackImageViewClicked() {
        mFragmentScreenSwitcher.goBack();
    }


    @OnClick(R.id.video_text_view)
    public void onVideoTextViewClicked() {
        setFragments(new VedioScreen());
    }

    @OnClick(R.id.followers_text_view)
    public void onFollowersTextViewClicked() {
        setFragments(new FollowersScreen());
    }

    @OnClick(R.id.following_text_view)
    public void onFollowingTextViewClicked() {
        setFragments(new FollowingScreen());
    }

    private void setFragments(final FragmentScreen mScreen) {
        FragmentManager mFragmentManager = getChildFragmentManager();
        mFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, mScreen.getFragment(), mScreen.getClass().getName())
                .commit();
    }
}
