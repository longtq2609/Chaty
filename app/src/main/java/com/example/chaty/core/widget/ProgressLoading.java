package com.example.chaty.core.widget;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import androidx.databinding.DataBindingUtil;

import com.example.chaty.R;
import com.example.chaty.databinding.LayoutChattyProgressBinding;

import java.util.Objects;

public class ProgressLoading {
    private Dialog dialog;
    private LayoutChattyProgressBinding viewBinding;

    public ProgressLoading(Context context) {
        viewBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.layout_chatty_progress, null, false);
        dialog = new ProgressDialog(context, R.style.ProgressDialogTheme) {
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(viewBinding.root);
                Objects.requireNonNull(getWindow()).setLayout(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
            }
        };
        dialog.setCancelable(false);
    }

    public void setContent(String content) {
        viewBinding.content.setText(content);
    }

    public void dismiss() {
        try {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show() {
        try {
            if (dialog != null && !dialog.isShowing()) {
                dialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showOnTime(int milisecond) {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
        new Handler().postDelayed(this::dismiss, milisecond);
    }

    public boolean isShowing() {
        return dialog != null && dialog.isShowing();
    }
}
