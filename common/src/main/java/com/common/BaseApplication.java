package com.common;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.common.base.dagger.BaseComponent;

import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class BaseApplication extends Application {

    private final String DEFAULT_FONT_PATH = "font/android_7.ttf";
    BaseComponent mBaseComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initCalligraphy();
        initTimber();
        initDependencyInjection();
    }

    private void initCalligraphy() {
        final CalligraphyConfig mCalligraphyConfig = new CalligraphyConfig.Builder()
                // .setDefaultFontPath(DEFAULT_FONT_PATH) // Todo: 04/12/2018 (GAZI) add default here
                .setFontAttrId(R.attr.fontPath)
                .build();
        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) {
            final Timber.DebugTree mdDebugTree = new Timber.DebugTree();
            Timber.plant(mdDebugTree);
        } else {
            final CrashReportingTree mCrashReportingTree = new CrashReportingTree();
            Timber.plant(mCrashReportingTree);
        }
    }

    private void initDependencyInjection() {
        mBaseComponent = BaseComponent.Initializer.init(this);
        mBaseComponent.inject(this);
    }

    public BaseComponent getBaseComponent() {
        return mBaseComponent;
    }

    public static BaseApplication getContext(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    private static class CrashReportingTree extends Timber.Tree {
        @Override
        protected void log(final int mPriority, final String mTag,
                           final String message, final Throwable mThrowable) {
            if (mPriority == Log.VERBOSE || mPriority == Log.DEBUG) {
                return;
            }
            CrashLibrary.log(mPriority, mTag, message);
            if (mThrowable != null) {
                if (mPriority == Log.ERROR) {
                    CrashLibrary.logError(mThrowable);
                } else if (mPriority == Log.WARN) {
                    CrashLibrary.logWarning(mThrowable);
                }
            }
        }
    }
}
