package com.common.base.navigation;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;

public interface HasFragmentContainer {

    @IdRes
    int getFragmentContainerId();

    FragmentManager getManager();
}
