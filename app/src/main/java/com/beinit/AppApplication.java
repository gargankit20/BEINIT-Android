package com.beinit;

import android.content.Context;

import com.common.BaseApplication;
import com.beinit.bestpractices.BuildConfig;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class AppApplication extends BaseApplication {
    private RefWatcher baseRefWatcher;
    private AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        baseRefWatcher = installLeakCanary();
        buildComponentAndInject();
    }

    private RefWatcher installLeakCanary() {
        if (BuildConfig.DEBUG) {
            return LeakCanary.install(this);
        } else {
            return RefWatcher.DISABLED;
        }
    }

    private void buildComponentAndInject() {
        mComponent = AppComponent.Initializer.init(this);
        mComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return mComponent;
    }

    public static RefWatcher getRefWatcher(final Context mContext) {
        final AppApplication mApplication = (AppApplication) mContext.getApplicationContext();
        return mApplication.baseRefWatcher;
    }

    public static AppApplication get(final Context mContext) {
        return (AppApplication) mContext.getApplicationContext();
    }
}
