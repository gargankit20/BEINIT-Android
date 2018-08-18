package com.beinit.base;

import com.common.base.BaseFragment;
import com.beinit.AppApplication;
import com.squareup.leakcanary.RefWatcher;

public abstract class AppBaseFragment extends BaseFragment {

    @Override
    public void onDestroy() {
        final RefWatcher mRefWatcher = AppApplication.getRefWatcher(getActivity());
        mRefWatcher.watch(this);
        super.onDestroy();
    }
}
