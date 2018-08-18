package com.common.base.dagger;

import com.common.BaseApplication;
import com.common.base.navigation.ActivityScreenSwitcher;
import com.common.base.navigation.FragmentScreenSwitcher;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseModule {
    private final BaseApplication application;

    public BaseModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @BaseScope
    BaseApplication provideBaseContext() {
        return this.application;
    }

    @Provides
    @BaseScope
    ActivityScreenSwitcher provideActivityScreenSwitcher() {
        return new ActivityScreenSwitcher();
    }

    @Provides
    @BaseScope
    FragmentScreenSwitcher provideFragmentScreenSwitcher() {
        return new FragmentScreenSwitcher();
    }

}
