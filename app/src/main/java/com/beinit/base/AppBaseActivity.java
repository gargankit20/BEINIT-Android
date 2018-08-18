package com.beinit.base;

import com.common.base.BaseActivity;
import com.beinit.AppApplication;
import com.squareup.leakcanary.RefWatcher;

public abstract class AppBaseActivity extends BaseActivity {

    @Override
    protected void onDestroy() {
        final RefWatcher mRefWatcher = AppApplication.getRefWatcher(this);
        mRefWatcher.watch(this);
        super.onDestroy();
    }
}
