package com.beinit.ui.dashboard.fragments.account.livestreaming;


import com.beinit.R;
import com.beinit.base.AppBaseFragment;
import com.beinit.ui.dashboard.DashboardComponent;
import com.beinit.ui.dashboard.fragments.account.livestreaming.favourites.FavouritesLiveStreamsScreen;
import com.beinit.ui.dashboard.fragments.account.livestreaming.mylivestreams.MyLiveStreamsScreen;
import com.common.base.navigation.FragmentScreenSwitcher;
import com.common.base.navigation.HasComponent;

import javax.inject.Inject;

import butterknife.OnClick;

public class LiveStreamingFragment extends AppBaseFragment {
    @Inject
    FragmentScreenSwitcher mFragmentScreenSwitcher;

    @Override
    protected int layoutId() {
        return R.layout.fragment_live_streaming;
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

    @OnClick(R.id.favourite_right_to_image_view)
    public void onFavouriteRightToImageViewClicked() {
        mFragmentScreenSwitcher.open(new FavouritesLiveStreamsScreen());
    }

    @OnClick(R.id.my_live_streams_right_to_image_view)
    public void onMyLiveStreamsRightToImageViewClicked() {
        mFragmentScreenSwitcher.open(new MyLiveStreamsScreen());
    }
}
