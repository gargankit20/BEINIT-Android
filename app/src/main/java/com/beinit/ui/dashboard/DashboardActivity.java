package com.beinit.ui.dashboard;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.beinit.AppApplication;
import com.beinit.R;
import com.beinit.base.AppBaseActivity;
import com.beinit.ui.dashboard.fragments.account.MyAccountScreen;
import com.beinit.ui.dashboard.fragments.discover.DiscoverScreen;
import com.beinit.ui.dashboard.fragments.home.HomeScreen;
import com.beinit.ui.dashboard.fragments.search.SearchScreen;
import com.beinit.ui.dashboard.fragments.stream.StreamScreen;
import com.common.base.navigation.FragmentScreenSwitcher;
import com.common.base.navigation.HasComponent;
import com.common.base.navigation.HasFragmentContainer;
import com.volcaniccoder.bottomify.BottomifyNavigationView;
import com.volcaniccoder.bottomify.OnNavigationItemChangeListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class DashboardActivity extends AppBaseActivity implements
        HasFragmentContainer, HasComponent<DashboardComponent>, OnNavigationItemChangeListener {

    @BindView(R.id.bottomify_navigation_view)
    BottomifyNavigationView mBottomifyNavigationView;

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
        mBottomifyNavigationView.setOnNavigationItemChangedListener(this);
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
    public void onNavigationItemChanged(BottomifyNavigationView.NavigationItem navigationItem) {
        switch (navigationItem.getPosition()) {
            case 0:
                mFragmentScreenSwitcher.openWithClearStackCheck(new HomeScreen());
                break;
            case 1:
                mFragmentScreenSwitcher.openWithClearStackCheck(new DiscoverScreen());
                break;
            case 2:
                mFragmentScreenSwitcher.openWithClearStackCheck(new StreamScreen());
                break;
            case 3:
                mFragmentScreenSwitcher.openWithClearStackCheck(new SearchScreen());
                break;
            case 4:
                mFragmentScreenSwitcher.openWithClearStackCheck(new MyAccountScreen());
                break;
        }
    }
}
