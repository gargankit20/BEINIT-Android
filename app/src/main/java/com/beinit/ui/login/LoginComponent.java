package com.beinit.ui.login;

import com.beinit.AppComponent;

import dagger.Component;

@LoginScope
@Component(dependencies = AppComponent.class, modules = {LoginModule.class})
public interface LoginComponent extends LoginGraph {

    void inject(LoginActivity mLoginActivity);
}
