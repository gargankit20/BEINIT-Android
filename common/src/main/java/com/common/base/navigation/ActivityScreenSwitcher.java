package com.common.base.navigation;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.common.base.BaseActivity;

import java.security.InvalidParameterException;

public class ActivityScreenSwitcher implements ScreenSwitcher<ActivityScreen> {

    private BaseActivity mActivity;

    public void attach(@NonNull BaseActivity mActivity) {
        this.mActivity = mActivity;
    }

    public void detach() {
        this.mActivity = null;
    }

    @Override
    public void open(@NonNull final ActivityScreen mScreen) {
        if (mActivity == null) {
            return;
        } else if (mScreen instanceof ActivityScreen) {
            final ActivityScreen activityScreen = mScreen;
            final Intent intent = activityScreen.intent(mActivity);
            ActivityCompat.startActivity(mActivity, intent,
                    activityScreen.activityOptions(mActivity));
        } else {
            throw new InvalidParameterException("Only ActivityScreen objects allowed");
        }
    }

    @Override
    public void goBack() {
        if (mActivity != null) {
            mActivity.onBackPressed();
        }
    }

    public void startForResult(final Screen mScreen, final int mRequestCode) {
        if (mActivity == null) {
            return;
        }
        if (mScreen instanceof ActivityScreen) {
            final ActivityScreen activityScreen = ((ActivityScreen) mScreen);
            final Intent mIntent = activityScreen.intent(mActivity);
            ActivityCompat.startActivityForResult(
                    mActivity,
                    mIntent,
                    mRequestCode,
                    activityScreen.activityOptions(mActivity));
        } else {
            throw new InvalidParameterException("Only ActivityScreen objects allowed");
        }
    }

    public void setResultAndGoBack(@Nullable Intent mData) {
        if (mActivity == null)
            return;
        if (mData != null)
            mActivity.setResult(Activity.RESULT_OK, mData);
        goBack();
    }
}
