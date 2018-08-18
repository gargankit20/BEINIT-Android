package com.beinit.ui.splash;

import com.beinit.AppComponent;

import dagger.Component;

@SplashScope
@Component(dependencies = AppComponent.class, modules = {SplashModule.class})
public interface SplashComponent extends SplashGraph {
    void inject(SplashActivity mSplashActivity);
}


