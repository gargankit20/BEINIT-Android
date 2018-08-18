package com.beinit.ui.dashboard;


import com.beinit.AppComponent;

import dagger.Component;

@DashboardScope
@Component(dependencies = AppComponent.class, modules = {DashboardModule.class})
public interface DashboardComponent extends DashboardGraph {

    void inject(DashboardActivity mActivity);
}


