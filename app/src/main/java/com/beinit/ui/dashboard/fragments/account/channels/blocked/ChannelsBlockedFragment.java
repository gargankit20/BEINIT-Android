package com.beinit.ui.dashboard.fragments.account.channels.blocked;


import com.beinit.R;
import com.beinit.base.AppBaseFragment;
import com.beinit.ui.dashboard.DashboardComponent;
import com.common.base.navigation.FragmentScreenSwitcher;
import com.common.base.navigation.HasComponent;

import javax.inject.Inject;

import butterknife.OnClick;

public class ChannelsBlockedFragment extends AppBaseFragment {

    @Inject
    FragmentScreenSwitcher mFragmentScreenSwitcher;

    @Override
    protected int layoutId() {
        return R.layout.fragment_channels_blocked;
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

}
