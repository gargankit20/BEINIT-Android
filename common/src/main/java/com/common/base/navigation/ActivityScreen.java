package com.common.base.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;

import com.common.base.BaseActivity;

public abstract class ActivityScreen implements Screen {

    private final static String BF_TRANSITION_VIEW = "ActivityScreen.transitionView";

    @Nullable
    private View mTransitionView;


    public void attachTransitionView(@Nullable final View mView) {
        mTransitionView = mView;
    }

    @Nullable
    protected View detachTransitionView() {
        final View mView = mTransitionView;
        mTransitionView = null;
        return mView;
    }

    protected final Intent intent(Context mContext) {
        Intent intent = new Intent(mContext, activityClass());
        configureIntent(intent);
        return intent;
    }

    protected final Bundle activityOptions(final Activity mActivity) {
        final View transitionView = detachTransitionView();
        if (transitionView == null) {
            return null;
        }
        return ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity,
                transitionView, BF_TRANSITION_VIEW).toBundle();
    }

    public static void setTransitionView(View view) {
        ViewCompat.setTransitionName(view, BF_TRANSITION_VIEW);
    }

    protected abstract Class<? extends BaseActivity> activityClass();

    protected abstract void configureIntent(@NonNull Intent intent);

}
