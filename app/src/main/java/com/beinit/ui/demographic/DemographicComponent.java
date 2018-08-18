package com.beinit.ui.demographic;


import com.beinit.AppComponent;

import dagger.Component;

@DemographicScope
@Component(dependencies = AppComponent.class, modules = {DemographicModule.class})
public interface DemographicComponent extends DemographicGraph {

    void inject(DemographicActivity mDemographicActivity);
}
