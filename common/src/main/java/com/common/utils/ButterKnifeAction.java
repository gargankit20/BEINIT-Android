package com.common.utils;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;

public class ButterKnifeAction {

    public static final ButterKnife.Action<View> VISIBLE = new ButterKnife.Action<View>() {
        @Override
        public void apply(@NonNull View view, int index) {
            view.setVisibility(View.VISIBLE);
        }
    };

    public static final ButterKnife.Action<View> INVISIBLE = new ButterKnife.Action<View>() {
        @Override
        public void apply(@NonNull View view, int index) {
            view.setVisibility(View.INVISIBLE);
        }
    };

    public static final ButterKnife.Action<View> GONE = new ButterKnife.Action<View>() {
        @Override
        public void apply(@NonNull View view, int index) {
            view.setVisibility(View.GONE);
        }
    };
    public static final ButterKnife.Action<EditText> HIDE_CURSOR = new ButterKnife.Action<EditText>() {
        @Override
        public void apply(EditText editText, int index) {
            editText.setCursorVisible(false);
        }
    };

    public static final ButterKnife.Action<EditText> SHOW_CURSOR = new ButterKnife.Action<EditText>() {

        @Override
        public void apply(EditText editText, int index) {
            editText.setCursorVisible(true);
        }
    };
    public static final ButterKnife.Action<View> DISABLE = new ButterKnife.Action<View>() {
        @Override
        public void apply(@NonNull View view, int index) {
            view.setEnabled(false);
        }
    };
    public static final ButterKnife.Setter<View, Boolean> ENABLED = new ButterKnife.Setter<View, Boolean>() {
        @Override
        public void set(@NonNull View view, Boolean value, int index) {
            view.setEnabled(value);
        }
    };

    public static final ButterKnife.Action<EditText> CLEAN = new ButterKnife.Action<EditText>() {
        @Override
        public void apply(@NonNull EditText view, int index) {
            view.setText("");
        }
    };

    public static final ButterKnife.Setter<View, Boolean> CLICKABLE = new ButterKnife.Setter<View, Boolean>() {
        @Override
        public void set(@NonNull View view, Boolean value, int index) {
            view.setClickable(value);
        }
    };

    public static ButterKnife.Setter<TextView, String> TEXT_CHANGE = new ButterKnife.Setter<TextView, String>() {
        @Override
        public void set(@NonNull TextView view, String value, int index) {
            view.setText(value);
        }
    };

    public static ButterKnife.Setter<CheckedTextView, Boolean> CHECKED = new ButterKnife.Setter<CheckedTextView, Boolean>() {
        @Override
        public void set(@NonNull CheckedTextView view, Boolean value, int index) {
            view.setChecked(true);
        }
    };
}
