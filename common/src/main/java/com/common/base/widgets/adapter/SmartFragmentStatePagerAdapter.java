package com.common.base.widgets.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

public abstract class SmartFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    // Sparse array to keep track of registered fragments in memory
    private SparseArray<Fragment> mRegisteredFragments = new SparseArray<>();

    public SmartFragmentStatePagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Register the fragment when the item is instantiated
    @Override
    public Object instantiateItem(final ViewGroup mContainer, final int mPosition) {
        final Fragment mFragment = (Fragment) super.instantiateItem(mContainer, mPosition);
        mRegisteredFragments.put(mPosition, mFragment);
        return mFragment;
    }

    // Unregister when the item is inactive
    @Override
    public void destroyItem(final ViewGroup mContainer, final int mPosition, final Object mObject) {
        mRegisteredFragments.remove(mPosition);
        super.destroyItem(mContainer, mPosition, mObject);
    }

    // Returns the fragment for the position (if instantiated)
    public Fragment getRegisteredFragment(int mPosition) {
        return mRegisteredFragments.get(mPosition);
    }
}