package com.beinit.ui.signup;


import com.beinit.AppComponent;

import dagger.Component;

@SignUpScope
@Component(dependencies = AppComponent.class, modules = {SignUpModule.class})
public interface SignUpComponent extends SignUpGraph {

    void inject(SignUpActivity mActivity);
}
