package com.beinit.ui.login;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;

import com.beinit.AppApplication;
import com.beinit.R;
import com.beinit.base.AppBaseActivity;
import com.beinit.ui.dashboard.DashboardScreen;
import com.beinit.ui.signup.SignUpScreen;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppBaseActivity {
    @BindView(R.id.user_name_edit_text)
    AppCompatEditText userNameEditText;

    @BindView(R.id.password_edit_text)
    AppCompatEditText passwordEditText;

    private LoginComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreateComponent() {
        mComponent = DaggerLoginComponent.builder()
                .appComponent(AppApplication.get(this).getAppComponent())
                .loginModule(new LoginModule())
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


    @OnClick(R.id.login_we_chat_button)
    public void onLoginWeChatButtonClicked() {
    }

    @OnClick(R.id.login_button)
    public void onLoginButtonClicked() {
        activityScreenSwitcher().open(new DashboardScreen(true));
    }

    @OnClick(R.id.forgot_password_button)
    public void onForgotPasswordButtonClicked() {
    }

    @OnClick(R.id.sign_up_button)
    public void onSignUpButtonClicked() {
        activityScreenSwitcher().open(new SignUpScreen(false));
        finish();
    }
}
