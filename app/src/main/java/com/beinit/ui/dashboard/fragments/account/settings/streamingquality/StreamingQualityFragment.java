package com.beinit.ui.dashboard.fragments.account.settings.streamingquality;

import com.beinit.R;
import com.beinit.base.AppBaseFragment;
import com.beinit.ui.dashboard.DashboardComponent;
import com.common.base.navigation.FragmentScreenSwitcher;
import com.common.base.navigation.HasComponent;

import javax.inject.Inject;

import butterknife.OnClick;

public class StreamingQualityFragment extends AppBaseFragment {

    @Inject
    FragmentScreenSwitcher mFragmentScreenSwitcher;

    @Override
    protected int layoutId() {
        return R.layout.fragment_streaming_quality;
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
