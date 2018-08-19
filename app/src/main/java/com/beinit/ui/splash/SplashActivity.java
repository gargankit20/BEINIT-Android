package com.beinit.ui.splash;

import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.beinit.AppApplication;
import com.beinit.R;
import com.beinit.base.AppBaseActivity;
import com.beinit.ui.demographic.DemographicScreen;

public class SplashActivity extends AppBaseActivity {
    private static final int AUTO_START_DELAY_MILLIS = 2000;
    private SplashComponent mComponent;
    private final Handler mHandler = new Handler();
    private final Runnable mActivityShowRunnable = new Runnable() {
        @Override
        public void run() {
            // todo Demographic or dasboard screen;
            activityScreenSwitcher().open(new DemographicScreen(true));
        }
    };

    @Override
    public int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreateComponent() {
        final AppApplication mApplication = AppApplication.get(this);
        mComponent = DaggerSplashComponent.builder()
                .appComponent(mApplication.getAppComponent())
                .splashModule(new SplashModule())
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
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(mActivityShowRunnable, AUTO_START_DELAY_MILLIS);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mActivityShowRunnable);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
