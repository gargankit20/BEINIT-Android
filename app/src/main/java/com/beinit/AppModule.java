package com.beinit;

import android.app.Application;

import com.common.BaseApplication;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {

    private final BaseApplication application;

    AppModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @AppScope
    Application provideAppContext() {
        return this.application;
    }
}
