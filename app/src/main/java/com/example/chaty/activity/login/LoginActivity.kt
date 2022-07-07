package com.example.chaty.activity.login

import com.example.chaty.R
import com.example.chaty.core.CoreActivity
import com.example.chaty.databinding.ActivityLoginBinding
import com.example.chaty.activity.loginphone.LoginPhoneFragment
import com.example.chaty.activity.register.RegisterActivity

class LoginActivity : CoreActivity<ActivityLoginBinding>() {

    override fun getLayoutId() = R.layout.activity_login

    override fun listener() {
        activityViewBinding.btnLogin.setOnClickListener {
            openNewActivity(LoginPhoneFragment::class.java)
        }
        activityViewBinding.btnSignUp.setOnClickListener {
            openNewActivity(RegisterActivity::class.java)
        }
    }

    override fun setupView() {
    }
}