package com.beinit.ui.demographic.fragments;


import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;

import com.beinit.base.AppBaseFragment;
import com.beinit.bestpractices.R;

import butterknife.BindView;


public class DemographicTitleFragment extends AppBaseFragment {
    @BindView(R.id.title_text_view)
    AppCompatTextView mTitleTextView;

    @Override
    protected int layoutId() {
        return R.layout.fragment_demographic_title;
    }

    @Override
    protected void injectToActivityComponent() {

    }

    @Override
    public void onShow() {

    }

    @Override
    protected void onExtractParams(Bundle mBundle) {
        super.onExtractParams(mBundle);
        final String mTitle = mBundle.getString(DemographicTitleScreen.TITLE);
        mTitleTextView.setText(mTitle);
    }
}
