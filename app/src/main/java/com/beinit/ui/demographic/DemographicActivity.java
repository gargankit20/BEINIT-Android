package com.beinit.ui.demographic;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.beinit.AppApplication;
import com.beinit.R;
import com.beinit.base.AppBaseActivity;
import com.beinit.ui.demographic.adapter.DemographicTitleAdapter;
import com.beinit.ui.login.LoginScreen;
import com.beinit.ui.signup.SignUpScreen;
import com.rd.PageIndicatorView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DemographicActivity extends AppBaseActivity implements SurfaceHolder.Callback {
    @BindView(R.id.video_view)
    SurfaceView mSurfaceView;

    @BindView(R.id.demographic_view_pager)
    ViewPager mDemographicViewPager;

    @BindView(R.id.page_indicator_view)
    PageIndicatorView mPageIndicatorView;

    @Inject
    DemographicTitleAdapter mDemographicTitleAdapter;
    private static final int AUTO_CHANGE_DELAY_MILLIS = 4000;
    private final Handler mHandler = new Handler();
    private final Runnable mViewPagerChangeRunnable = new Runnable() {
        @Override
        public void run() {
            int mPosition = mDemographicViewPager.getCurrentItem() + 1;
            if (mPosition >= mDemographicViewPager.getAdapter().getCount()) {
                mPosition = 0;
            }
            mDemographicViewPager.setCurrentItem(mPosition);
            mHandler.postDelayed(mViewPagerChangeRunnable, AUTO_CHANGE_DELAY_MILLIS);
        }
    };

    MediaPlayer mMediaPlayer;
    private int mCurrentPosition = 0;
    private final String PLAYBACK_TIME = "play_time";
    private DemographicComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
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
        mCurrentPosition = mParams.getInt(PLAYBACK_TIME);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDemographicViewPager.setAdapter(mDemographicTitleAdapter);
        mPageIndicatorView.setViewPager(mDemographicViewPager);
    }

    @Override
    public void surfaceCreated(final SurfaceHolder mHolder) {
        Log.d("GGGGGGGG", "surfaceCreated");
        try {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDisplay(mHolder);
            final AssetFileDescriptor mDescriptor = getAssets().openFd("demographic_video.mp4");
            mMediaPlayer.setDataSource(mDescriptor.getFileDescriptor(),
                    mDescriptor.getStartOffset(),
                    mDescriptor.getLength());
            mDescriptor.close();
            mMediaPlayer.prepareAsync();
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.setLooping(true);
                    Log.d("GGGGGGGG", "GGGGGG");
                    mediaPlayer.seekTo(mCurrentPosition);
                    mediaPlayer.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(mViewPagerChangeRunnable, AUTO_CHANGE_DELAY_MILLIS);
        mSurfaceView.getHolder().addCallback(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        final Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mMediaPlayer != null) {
                    mCurrentPosition = mMediaPlayer.getCurrentPosition();
                    Log.d("FFFFFFFFFFFF", mCurrentPosition + "");
                }
            }
        }, 1);
        mHandler.removeCallbacks(mViewPagerChangeRunnable);
        mSurfaceView.getHolder().removeCallback(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle mBundle) {
        super.onSaveInstanceState(mBundle);
        mBundle.putInt(PLAYBACK_TIME, mCurrentPosition);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
        }
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
