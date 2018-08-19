package com.beinit.ui.dashboard;


import com.beinit.AppComponent;
import com.beinit.ui.dashboard.fragments.account.AccountFragment;
import com.beinit.ui.dashboard.fragments.discover.DiscoverFragment;
import com.beinit.ui.dashboard.fragments.home.HomeFragment;
import com.beinit.ui.dashboard.fragments.search.SearchFragment;
import com.beinit.ui.dashboard.fragments.stream.StreamFragment;

import dagger.Component;

@DashboardScope
@Component(dependencies = AppComponent.class, modules = {DashboardModule.class})
public interface DashboardComponent extends DashboardGraph {

    void inject(DashboardActivity mActivity);

    void inject(HomeFragment mFragment);

    void inject(DiscoverFragment mFragment);

    void inject(StreamFragment mFragment);

    void inject(SearchFragment mFragment);

    void inject(AccountFragment mFragment);
}


