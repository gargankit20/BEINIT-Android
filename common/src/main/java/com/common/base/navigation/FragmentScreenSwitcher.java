package com.common.base.navigation;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.common.R;
import com.common.base.BaseFragment;
import com.common.utils.Strings;

import java.util.List;

public class FragmentScreenSwitcher implements ScreenSwitcher<FragmentScreen>,
        FragmentManager.OnBackStackChangedListener {

    private HasFragmentContainer mActivity;

    @IdRes
    private int mFragmentContainerId;

    private FragmentManager mFragmentManager;

    @Nullable
    private String mResultFragmentTag;

    @Nullable
    private Integer mRequestCode;

    public void attach(HasFragmentContainer mActivity) {
        this.mActivity = mActivity;
        this.mFragmentContainerId = mActivity.getFragmentContainerId();
        this.mFragmentManager = mActivity.getManager();
        this.mFragmentManager.addOnBackStackChangedListener(this);
    }

    public boolean hasFragments() {
        final List<Fragment> mFragments = mFragmentManager.getFragments();
        return mFragments != null && !mFragments.isEmpty();
    }

    @Override
    public void open(final FragmentScreen mScreen) {
        mResultFragmentTag = mScreen.getName();
        final List<Fragment> fragments = mFragmentManager.getFragments();
        if (fragments == null || fragments.isEmpty()) {
            replace(mScreen);
        } else {
            add(mScreen);
        }
    }

    public void openWithClearStackCheck(final FragmentScreen mScreen) {
        if (!mScreen.getName().equals(mResultFragmentTag)) {
            openWithClearStack(mScreen);
        }
    }

    public void openWithClearStack(FragmentScreen mFragmentScreen) {
        final int mBackStackEntryCount = mFragmentManager.getBackStackEntryCount();
        for (int mIndex = 0; mIndex < mBackStackEntryCount; mIndex++) {
            mFragmentManager.popBackStack();
        }
        mResultFragmentTag = mFragmentScreen.getName();
        replace(mFragmentScreen);
        final BaseFragment mNewFragment = (BaseFragment) mFragmentScreen.getFragment();
        if (mNewFragment != null) {
            mNewFragment.setAfterClearStack(true);
            //after replace don`t called "onBackStackChanged()", consequently, don`t called "onShow();
        }
    }

    public void startForResult(final FragmentScreen mScreen, int mRequestCode) {
        this.mRequestCode = mRequestCode;
        add(mScreen);
    }

    @Override
    public void goBack() {
        mFragmentManager.popBackStack();
    }

    public void detach() {
        mActivity = null;
        mFragmentManager = null;
        mFragmentContainerId = 0;
    }

    public void onFragmentResult(final Intent mIntent) {
        goBack();
        if (!Strings.isBlank(mResultFragmentTag) && mRequestCode != null) {
            final Fragment mFragmentByTag = mFragmentManager.findFragmentByTag(mResultFragmentTag);
            mFragmentByTag.onActivityResult(mRequestCode, Activity.RESULT_OK, mIntent);
            mRequestCode = null;
        }
    }


    private void replace(final FragmentScreen mScreen) {
        mFragmentManager.beginTransaction()
                .replace(mFragmentContainerId, mScreen.getFragment(), mScreen.getName())
                .commit();
    }

    private void add(final FragmentScreen mScreen) {
        final String mName = mScreen.getName();
        mFragmentManager.beginTransaction()
                .add(mFragmentContainerId, mScreen.getFragment(), mName)
                .addToBackStack(mName)
                .setCustomAnimations(R.anim.right_in, R.anim.left_out, R.anim.left_in, R.anim.right_out)
                .commit();
    }


    @Override
    public void onBackStackChanged() {
        final String mCurrentFragmentTag;
        final int mBackStackEntryCount = mFragmentManager.getBackStackEntryCount();
        if (mBackStackEntryCount == 0) {
            mCurrentFragmentTag = mFragmentManager.findFragmentById(mFragmentContainerId).getTag();
        } else {
            mCurrentFragmentTag = mFragmentManager
                    .getBackStackEntryAt(mBackStackEntryCount - 1).getName();
        }
        final BaseFragment mCurrentFragment = (BaseFragment) mFragmentManager
                .findFragmentByTag(mCurrentFragmentTag);
        if (mCurrentFragment != null) {
            mCurrentFragment.onShow();
        }
    }

    public int getBackStackCount() {
        return mFragmentManager.getBackStackEntryCount();
    }
}
