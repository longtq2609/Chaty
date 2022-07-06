package com.example.chaty.login.loginphone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chaty.R

class LoginPhoneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login_phone, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoginPhoneFragment().apply {

            }
    }
}