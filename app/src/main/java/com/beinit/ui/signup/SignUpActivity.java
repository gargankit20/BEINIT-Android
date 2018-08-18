package com.beinit.ui.signup;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.beinit.AppApplication;
import com.beinit.bestpractices.R;
import com.beinit.base.AppBaseActivity;

public class SignUpActivity extends AppBaseActivity {
    private SignUpComponent mComponent;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_sign_up;
    }

    @Override
    protected void onCreateComponent() {
        mComponent = DaggerSignUpComponent.builder()
                .appComponent(AppApplication.get(this).getAppComponent())
                .signUpModule(new SignUpModule())
                .build();
        mComponent.inject(this);
    }

    @Override
    protected void destroyComponent() {
        mComponent = null;
    }

    @Override
    protected boolean haveToolbar() {
        return true;
    }

    @Override
    protected int resToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected void initToolbarForChildActivity(ActionBar actionBar, Toolbar mToolbar) {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
