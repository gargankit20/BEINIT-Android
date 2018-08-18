package com.beinit.ui.dashboard;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.common.base.BaseActivity;
import com.common.base.navigation.ActivityScreen;

public class DashboardScreen extends ActivityScreen {

    public static final String NEED_TO_CLEAR_STACK = "DashboardScreen.ClearStack";
    private final boolean needClearStack;

    public DashboardScreen(boolean clearActivityStack) {
        this.needClearStack = clearActivityStack;
    }

    @Override
    protected Class<? extends BaseActivity> activityClass() {
        return DashboardActivity.class;
    }

    @Override
    protected void configureIntent(@NonNull Intent intent) {
        if (needClearStack) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION
                    | Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.putExtra(NEED_TO_CLEAR_STACK, needClearStack);
        }
    }
}
