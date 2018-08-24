package com.beinit.ui.dashboard.fragments.account.settings;

import com.beinit.R;
import com.beinit.base.AppBaseFragment;
import com.beinit.ui.dashboard.DashboardComponent;
import com.beinit.ui.dashboard.fragments.account.settings.about.AboutScreen;
import com.beinit.ui.dashboard.fragments.account.settings.changepassword.ChangePasswordScreen;
import com.beinit.ui.dashboard.fragments.account.settings.account.AccountScreen;
import com.beinit.ui.dashboard.fragments.account.settings.social.SocialScreen;
import com.beinit.ui.dashboard.fragments.account.settings.streamingquality.SteamingQualityScreen;
import com.common.base.navigation.FragmentScreenSwitcher;
import com.common.base.navigation.HasComponent;

import javax.inject.Inject;

import butterknife.OnClick;

public class SettingFragment extends AppBaseFragment {

    @Inject
    FragmentScreenSwitcher mFragmentScreenSwitcher;

    @Override
    protected int layoutId() {
        return R.layout.fragment_setting;
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
    public void onBackImageViewClicked() {
        mFragmentScreenSwitcher.goBack();
    }

    @OnClick(R.id.account_right_to_image_view)
    public void onAccountRightToImageViewClicked() {
        mFragmentScreenSwitcher.open(new AccountScreen());
    }

    @OnClick(R.id.change_password_right_to_image_view)
    public void onChangePasswordRightToImageViewClicked() {
        mFragmentScreenSwitcher.open(new ChangePasswordScreen());
    }

    @OnClick(R.id.social_right_to_image_view)
    public void onSocialRightToImageViewClicked() {
        mFragmentScreenSwitcher.open(new SocialScreen());
    }

    @OnClick(R.id.notification_right_to_image_view)
    public void onNotificationRightToImageViewClicked() {
    }

    @OnClick(R.id.about_right_to_image_view)
    public void onAboutRightToImageViewClicked() {
        mFragmentScreenSwitcher.open(new AboutScreen());
    }

    @OnClick(R.id.device_text_view)
    public void onDeviceTextViewClicked() {
    }

    @OnClick(R.id.logout_text_view)
    public void onLogoutTextViewClicked() {
    }

    @OnClick(R.id.streaming_quality_right_to_image_view)
    public void onViewClicked() {
        mFragmentScreenSwitcher.open(new SteamingQualityScreen());
    }
}
