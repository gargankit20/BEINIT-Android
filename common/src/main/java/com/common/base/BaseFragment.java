package com.common.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

public abstract class BaseFragment extends Fragment {

    protected final String TAG = this.getClass().getSimpleName();
    private boolean mAfterClearStack = false;
    private Unbinder unbinder;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.tag(getClass().getSimpleName());
        injectToActivityComponent();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int layoutId = layoutId();
        final View mView = inflater.inflate(layoutId, container, false);
        unbinder = ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();
        final Bundle mBundle = getArguments();
        onExtractParams(mBundle);
        if (mAfterClearStack) {
            onShow();
        }
    }

    protected void onExtractParams(final Bundle mBundle) {
    }

    public void onFragmentResult(int requestCode, Bundle params) {
    }

    public void setAfterClearStack(final boolean mAfterClearStack) {
        this.mAfterClearStack = mAfterClearStack;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @LayoutRes
    protected abstract int layoutId();

    protected abstract void injectToActivityComponent();

    public abstract void onShow();
}
