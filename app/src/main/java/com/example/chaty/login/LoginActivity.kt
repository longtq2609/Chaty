package com.example.chaty.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.chaty.R
import com.example.chaty.databinding.ActivityLoginBinding
import com.example.chaty.login.loginphone.LoginPhoneFragment
import com.example.chaty.login.register.RegisterFragment

class LoginActivity : AppCompatActivity() {
    private lateinit var  viewBinding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        init()
    }

    private fun init(){
        viewBinding.btnLogin.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, LoginPhoneFragment.newInstance()).commit()
        }
        viewBinding.btnSignUp.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, RegisterFragment.newInstance()).commit()

        }
    }
}