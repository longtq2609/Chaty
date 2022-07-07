package com.example.chaty.core.util

import android.app.Activity
import android.widget.EditText
import com.blankj.utilcode.util.KeyboardUtils

object AppHelper {

    @JvmStatic
    fun hideKeyboard(context: Activity) {
        KeyboardUtils.hideSoftInput(context);
    }

    @JvmStatic
    fun showKeyboard(activity: Activity, editText: EditText) {
        KeyboardUtils.showSoftInput(editText)
    }
}