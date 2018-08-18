package com.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.common.BaseApplication;
import com.common.R;
import com.common.base.navigation.ActivityScreenSwitcher;

import javax.annotation.Nullable;
import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();

    @Nullable
    private Toolbar mToolbar;

    @Inject
    ActivityScreenSwitcher mActivityScreenSwitcher;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(getLayoutResId());
        injectBaseActivity();
        initToolbar();
        onCreateComponent();
        final Bundle mParams = getIntent().getExtras();
        if (mParams != null) {
            onExtractParams(mParams);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mActivityScreenSwitcher.attach(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mActivityScreenSwitcher.detach();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        destroyComponent();
        super.onDestroy();
    }

    private void injectBaseActivity() {
        final BaseApplication mApplication = BaseApplication.getContext(this);
        mApplication.getBaseComponent().inject(this);
    }

    private void initToolbar() {
        int toolbarResId = resToolbarId();
        if (haveToolbar() && toolbarResId != 0) {
            mToolbar = findViewById(resToolbarId());
            setSupportActionBar(mToolbar);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onArrowClick();
                }
            });
            initToolbarForChildActivity(getSupportActionBar(), mToolbar);
        }
    }

    protected void onExtractParams(final Bundle mParams) {
    }

    protected void onArrowClick() {
        mActivityScreenSwitcher.goBack();
    }

    protected ActivityScreenSwitcher activityScreenSwitcher() {
        return mActivityScreenSwitcher;
    }

    protected Toolbar getToolbar() {
        if (mToolbar == null) {
            new Throwable(new NullPointerException(getResources().
                    getString(R.string.toolbar_null_pointer_exception)));
        }
        return mToolbar;
    }

    public abstract int getLayoutResId();

    protected abstract void onCreateComponent();

    protected abstract void destroyComponent();

    protected abstract boolean haveToolbar();

    protected abstract int resToolbarId();

    protected abstract void initToolbarForChildActivity(ActionBar actionBar, Toolbar mToolbar);
}

