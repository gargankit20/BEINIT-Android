package com.beinit.ui.dashboard.fragments.account.videos;

import com.beinit.R;
import com.beinit.base.AppBaseFragment;
import com.beinit.ui.dashboard.DashboardComponent;
import com.beinit.ui.dashboard.fragments.account.videos.favourites.FavouritesVideosScreen;
import com.beinit.ui.dashboard.fragments.account.videos.myvideos.MyVideosScreen;
import com.common.base.navigation.FragmentScreenSwitcher;
import com.common.base.navigation.HasComponent;

import javax.inject.Inject;

import butterknife.OnClick;


public class VideosFragment extends AppBaseFragment {

    @Inject
    FragmentScreenSwitcher mFragmentScreenSwitcher;

    @Override
    protected int layoutId() {
        return R.layout.fragment_videos;
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
        mFragmentScreenSwitcher.open(new FavouritesVideosScreen());
    }

    @OnClick(R.id.my_videos_right_to_image_view)
    public void onMyVideosRightToImageViewClicked() {
        mFragmentScreenSwitcher.open(new MyVideosScreen());
    }
}
