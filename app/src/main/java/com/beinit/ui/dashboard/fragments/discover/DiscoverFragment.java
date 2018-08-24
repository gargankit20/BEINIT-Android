package com.beinit.ui.dashboard.fragments.discover;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.beinit.R;
import com.beinit.base.AppBaseFragment;
import com.beinit.model.Category;
import com.beinit.model.Channel;
import com.beinit.model.ChannelAndCategoriesModel;
import com.beinit.network.ApiService;
import com.beinit.ui.dashboard.DashboardComponent;
import com.beinit.ui.dashboard.fragments.discover.fragments.CategoriesFragment;
import com.beinit.ui.dashboard.fragments.discover.fragments.adapter.ChannelAdapter;
import com.beinit.widget.LockableViewPager;
import com.common.base.navigation.HasComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class DiscoverFragment extends AppBaseFragment {
    @BindView(R.id.view_pager)
    LockableViewPager mViewPager;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @Inject
    ApiService mApiService;

    @Inject
    ChannelAdapter mChannelAdapter;

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected int layoutId() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void injectToActivityComponent() {
        final DashboardComponent mComponent =
                ((HasComponent<DashboardComponent>) getActivity()).getComponent();
        mComponent.inject(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        final DiscoverFragmentAdapter mAdapter =
                new DiscoverFragmentAdapter(getContext(), getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setSwipeable(false);
        tabLayout.setupWithViewPager(mViewPager);

        mDisposable.add(channelAndCategoriesModelObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<ChannelAndCategoriesModel>() {
                    @Override
                    public void onNext(ChannelAndCategoriesModel channelAndCategoriesModel) {
                        final List<Category> categories = channelAndCategoriesModel.getData().getCategories();
                        final List<Channel> channel = channelAndCategoriesModel.getData().getChannel();
                        mChannelAdapter.clean();
                        mChannelAdapter.addItems(channel);

                        final Fragment fragment = mAdapter.getRegisteredFragment(1);
                        if (fragment instanceof CategoriesFragment) {
                            CategoriesFragment mFragment = (CategoriesFragment) fragment;
                            mFragment.setData(categories);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    private Observable<ChannelAndCategoriesModel> channelAndCategoriesModelObservable() {
        return mApiService.getChannelAndCategoriesModelData();
    }

    @Override
    public void onShow() {
    }

    @Override
    public void onStop() {
        super.onStop();
        mDisposable.clear();
    }
}
