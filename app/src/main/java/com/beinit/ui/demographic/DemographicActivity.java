package com.beinit.ui.demographic;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.beinit.AppApplication;
import com.beinit.R;
import com.beinit.base.AppBaseActivity;
import com.beinit.player.PlayerManager;
import com.beinit.ui.demographic.adapter.DemographicTitleAdapter;
import com.beinit.ui.login.LoginScreen;
import com.beinit.ui.signup.SignUpScreen;
import com.google.android.exoplayer2.ui.PlayerView;
import com.rd.PageIndicatorView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DemographicActivity extends AppBaseActivity {
    @BindView(R.id.player_view)
    PlayerView mPlayerView;

    @BindView(R.id.demographic_view_pager)
    ViewPager mDemographicViewPager;

    @BindView(R.id.page_indicator_view)
    PageIndicatorView mPageIndicatorView;

    @Inject
    DemographicTitleAdapter mDemographicTitleAdapter;

    private long mCurrentPosition;
    private static final int AUTO_CHANGE_DELAY_MILLIS = 4000;
    private final Handler mHandler = new Handler();
    private final Runnable mViewPagerChangeRunnable = new Runnable() {
        @Override
        public void run() {
            int mPosition = mDemographicViewPager.getCurrentItem() + 1;
            final PagerAdapter adapter = mDemographicViewPager.getAdapter();
            if (adapter != null && mPosition >= adapter.getCount()) {
                mPosition = 0;
            }
            mDemographicViewPager.setCurrentItem(mPosition);
            mHandler.postDelayed(mViewPagerChangeRunnable, AUTO_CHANGE_DELAY_MILLIS);
        }
    };

    private PlayerManager mPlayerManager;
    private final String PLAYBACK_TIME = "play_time";
    private DemographicComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mPlayerManager = new PlayerManager(this);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_demographic;
    }

    @Override
    protected void onCreateComponent() {
        mComponent = DaggerDemographicComponent.builder()
                .appComponent(AppApplication.get(this).getAppComponent())
                .demographicModule(new DemographicModule(this, getSupportFragmentManager()))
                .build();
        mComponent.inject(this);
    }

    @Override
    protected void destroyComponent() {
        mComponent = null;
    }

    @Override
    protected boolean haveToolbar() {
        return false;
    }

    @Override
    protected int resToolbarId() {
        return -1;
    }

    @Override
    protected void initToolbarForChildActivity(ActionBar actionBar, Toolbar mToolbar) {
    }

    @Override
    protected void onExtractParams(Bundle mParams) {
        super.onExtractParams(mParams);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDemographicViewPager.setAdapter(mDemographicTitleAdapter);
        mPageIndicatorView.setViewPager(mDemographicViewPager);
    }

    @Override
    protected void onRestoreInstanceState(Bundle mParams) {
        super.onRestoreInstanceState(mParams);
        if (mParams != null) {
            mCurrentPosition = mParams.getLong(PLAYBACK_TIME, 0);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlayerManager.init(this, mPlayerView, mCurrentPosition, R.raw.demographic_video);
        mHandler.postDelayed(mViewPagerChangeRunnable, AUTO_CHANGE_DELAY_MILLIS);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCurrentPosition = mPlayerManager.getContentPosition();
        mPlayerManager.reset();
        mHandler.removeCallbacks(mViewPagerChangeRunnable);
    }

    @Override
    protected void onSaveInstanceState(Bundle mBundle) {
        super.onSaveInstanceState(mBundle);
        mBundle.putLong(PLAYBACK_TIME, mCurrentPosition);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayerManager.release();
    }

    @OnClick(R.id.login_button)
    public void onLoginButtonClicked() {
        activityScreenSwitcher().open(new LoginScreen(false));
    }

    @OnClick(R.id.sign_up_button)
    public void onSignUpButtonClicked() {
        activityScreenSwitcher().open(new SignUpScreen(false));
    }
}
