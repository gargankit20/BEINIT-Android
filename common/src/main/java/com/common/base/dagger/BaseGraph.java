package com.common.base.dagger;

import com.common.base.navigation.ActivityScreenSwitcher;
import com.common.base.navigation.FragmentScreenSwitcher;

public interface BaseGraph {
    ActivityScreenSwitcher activityScreenSwitcher();

    FragmentScreenSwitcher fragmentScreenSwitcher();
}
