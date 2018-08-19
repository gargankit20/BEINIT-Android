package com.beinit.ui.dashboard;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.beinit.AppApplication;
import com.beinit.R;
import com.beinit.base.AppBaseActivity;
import com.beinit.ui.dashboard.fragments.account.AccountScreen;
import com.beinit.ui.dashboard.fragments.discover.DiscoverScreen;
import com.beinit.ui.dashboard.fragments.home.HomeScreen;
import com.beinit.ui.dashboard.fragments.search.SearchScreen;
import com.beinit.ui.dashboard.fragments.stream.StreamScreen;
import com.common.base.navigation.FragmentScreenSwitcher;
import com.common.base.navigation.HasComponent;
import com.common.base.navigation.HasFragmentContainer;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class DashboardActivity extends AppBaseActivity implements HasFragmentContainer,
        HasComponent<DashboardComponent>, BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomNavigation;

    @Inject
    FragmentScreenSwitcher mFragmentScreenSwitcher;

    private DashboardComponent dashboardComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

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
        actionBar.hide();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFragmentScreenSwitcher.attach(this);
        Timber.d(!mFragmentScreenSwitcher.hasFragments() + "");
        if (!mFragmentScreenSwitcher.hasFragments()) {
            mFragmentScreenSwitcher.openWithClearStack(new HomeScreen());
        }
        mBottomNavigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mFragmentScreenSwitcher.detach();
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

    @Override
    public boolean onNavigationItemSelected(final @NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                mFragmentScreenSwitcher.openWithClearStackCheck(new HomeScreen());
                return true;
            case R.id.action_discover:
                mFragmentScreenSwitcher.openWithClearStackCheck(new DiscoverScreen());
                return true;
            case R.id.action_live_stream:
                mFragmentScreenSwitcher.openWithClearStackCheck(new StreamScreen());
                return true;
            case R.id.action_search:
                mFragmentScreenSwitcher.openWithClearStackCheck(new SearchScreen());
                return true;
            case R.id.action_account:
                mFragmentScreenSwitcher.openWithClearStackCheck(new AccountScreen());
                return true;
        }
        return false;
    }
}
