package com.example.chaty.activity.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.chaty.R
import com.example.chaty.core.CoreActivity
import com.example.chaty.databinding.ActivityMainBinding
import com.example.chaty.fragment.contract.ContractFragment
import com.example.chaty.fragment.message.MessageFragment
import com.example.chaty.fragment.profile.ProfileFragment

class MainActivity : CoreActivity<ActivityMainBinding>() {
    private lateinit var fragmentManager: FragmentManager

    private fun setupBottomNavigation() {
        fragmentManager = supportFragmentManager
        setCurrentFragment(MessageFragment.newInstance())
        activityViewBinding.ahTabContain.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.tab_message -> {
                    setCurrentFragment(
                        MessageFragment.newInstance()
                    )
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tab_contract -> {
                    setCurrentFragment(ContractFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tab_profile -> {
                    setCurrentFragment(
                        ProfileFragment.newInstance()
                    )
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit()
    }

    override fun getLayoutId() = R.layout.activity_main
    override fun listener() {
        setupBottomNavigation()
    }

    override fun setupView() {
    }
}