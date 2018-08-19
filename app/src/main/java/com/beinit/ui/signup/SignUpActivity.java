package com.beinit.ui.signup;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.beinit.AppApplication;
import com.beinit.R;
import com.beinit.base.AppBaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppBaseActivity {
    @BindView(R.id.terms_text_view)
    AppCompatTextView mTermsTextView;

    private SignUpComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

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
        mTermsTextView.setMovementMethod(LinkMovementMethod.getInstance());
        mTermsTextView.setText(getTermsAndConditionText(), TextView.BufferType.EDITABLE);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private SpannableStringBuilder getTermsAndConditionText() {
        final String firstWord = "By signing up, you agree to Be in it\n";
        final String secondWord = "Terms and conditions of use";
        final String thirdWord = " and ";
        final String forthWord = "Privacy Policy";

        final ForegroundColorSpan firstWordColorSpan = new ForegroundColorSpan(
                getResources().getColor(android.R.color.white));
        final SpannableStringBuilder ssb = new SpannableStringBuilder(firstWord);
        ssb.append(secondWord);
        ssb.setSpan(
                firstWordColorSpan,
                firstWord.length(),
                ssb.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        final ClickableSpan termsClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
            }
        };
        ssb.setSpan(termsClickableSpan, firstWord.length(),
                ssb.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ssb.append(thirdWord);
        int length = ssb.length();
        ssb.append(forthWord);
        final ForegroundColorSpan forthWordColorSpan = new ForegroundColorSpan(
                getResources().getColor(android.R.color.white));
        ssb.setSpan(forthWordColorSpan,
                length,
                ssb.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        final ClickableSpan conditionClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
            }
        };
        ssb.setSpan(conditionClickableSpan,
                length,
                ssb.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return ssb;
    }
}
