package com.beinit.ui.dashboard.fragments.discover.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.beinit.R;
import com.beinit.base.AppBaseFragment;
import com.beinit.ui.dashboard.DashboardComponent;
import com.beinit.ui.dashboard.fragments.discover.fragments.adapter.ChannelAdapter;
import com.beinit.widget.StaggeredGridBorderDecoration;
import com.common.base.navigation.HasComponent;

import javax.inject.Inject;

import butterknife.BindView;


public class ChannelFragment extends AppBaseFragment {
    @BindView(R.id.channel_recycler_view)
    RecyclerView mChannelRecyclerView;

    @Inject
    ChannelAdapter mChannelAdapter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_channel;
    }

    @Override
    protected void injectToActivityComponent() {
        final DashboardComponent mComponent =
                ((HasComponent<DashboardComponent>) getActivity()).getComponent();
        mComponent.inject(this);
    }

    @Override
    public void onShow() {

    }

    @Override
    public void onStart() {
        super.onStart();
        mChannelRecyclerView.setAdapter(mChannelAdapter);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mChannelRecyclerView.setLayoutManager(gridLayoutManager);
        final int size = getResources().getDimensionPixelSize(R.dimen.spacing_small_tiny);
        final ColorDrawable drawable = new ColorDrawable(Color.BLACK);
        final StaggeredGridBorderDecoration decoration = new StaggeredGridBorderDecoration(size, drawable);
        mChannelRecyclerView.addItemDecoration(decoration);
    }
}
