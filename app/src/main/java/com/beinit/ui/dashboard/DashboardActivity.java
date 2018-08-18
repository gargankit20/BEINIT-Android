package com.beinit.ui.dashboard;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.beinit.AppApplication;
import com.beinit.base.AppBaseActivity;
import com.beinit.bestpractices.R;
import com.common.base.navigation.HasComponent;
import com.common.base.navigation.HasFragmentContainer;

public class DashboardActivity extends AppBaseActivity implements HasFragmentContainer, HasComponent<DashboardComponent> {
    private DashboardComponent dashboardComponent;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_dashboard;
    }

    @Override
    protected void onCreateComponent() {
        final AppApplication mApplication = AppApplication.get(this);
        dashboardComponent = DaggerDashboardComponent.builder()
                .appComponent(mApplication.getAppComponent())
                .dashboardModule(new DashboardModule(this, getToolbar()))
                .build();
        dashboardComponent.inject(this);
    }

    @Override
    protected void destroyComponent() {
        dashboardComponent = null;
    }

    @Override
    protected boolean haveToolbar() {
        return true;
    }

    @Override
    protected int resToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected void initToolbarForChildActivity(ActionBar actionBar, Toolbar mToolbar) {

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public DashboardComponent getComponent() {
        return dashboardComponent;
    }

    @Override
    public int getFragmentContainerId() {
        return R.id.fragment_container;
    }

    @Override
    public FragmentManager getManager() {
        return getSupportFragmentManager();
    }
}
