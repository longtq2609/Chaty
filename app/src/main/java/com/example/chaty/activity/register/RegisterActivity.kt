package com.example.chaty.activity.register

import com.example.chaty.R
import com.example.chaty.core.CoreActivity
import com.example.chaty.databinding.ActivityRegisterBinding


class RegisterActivity : CoreActivity<ActivityRegisterBinding>() {
    override fun getLayoutId() = R.layout.activity_register
    override fun listener() {
        activityViewBinding.btnClose.setOnClickListener {
            baseActivity?.onBackPressed()
        }
    }

    override fun setupView() {
    }


}