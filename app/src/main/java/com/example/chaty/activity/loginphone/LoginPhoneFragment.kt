package com.example.chaty.activity.loginphone

import com.example.chaty.R
import com.example.chaty.activity.main.MainActivity
import com.example.chaty.core.CoreActivity
import com.example.chaty.databinding.ActivityLoginPhoneBinding

class LoginPhoneFragment : CoreActivity<ActivityLoginPhoneBinding>() {

    override fun getLayoutId() = R.layout.activity_login_phone

    override fun initViewModel() {
    }

    override fun listener() {
        activityViewBinding.btnClose.setOnClickListener {
            baseActivity?.onBackPressed()
        }
        activityViewBinding.btnLogin.setOnClickListener {
            openNewActivity(MainActivity::class.java)
        }
    }

    override fun setupView() {
    }


}