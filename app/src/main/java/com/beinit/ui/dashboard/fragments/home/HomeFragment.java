package com.beinit.ui.dashboard.fragments.home;

import android.net.Uri;

import com.beinit.R;
import com.beinit.base.AppBaseFragment;
import com.beinit.player.PlayerManager;
import com.beinit.ui.dashboard.DashboardComponent;
import com.common.base.navigation.HasComponent;
import com.google.android.exoplayer2.ui.PlayerView;

import butterknife.BindView;

public class HomeFragment extends AppBaseFragment {

    @BindView(R.id.player_view)
    PlayerView mPlayerView;

    private PlayerManager mPlayerManager;

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
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
        mPlayerManager = new PlayerManager(getContext());
    }

    @Override
    public void onResume() {
        super.onResume();
        String contentUrl = getString(R.string.stream_url);
        mPlayerManager.init(getContext(), mPlayerView, Uri.parse(contentUrl));
    }

    @Override
    public void onPause() {
        super.onPause();
        mPlayerManager.reset();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayerManager.release();
    }
}
