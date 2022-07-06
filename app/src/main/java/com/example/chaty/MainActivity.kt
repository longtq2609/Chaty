package com.example.chaty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.chaty.contract.ContractFragment
import com.example.chaty.databinding.ActivityMainBinding
import com.example.chaty.message.MessageFragment
import com.example.chaty.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        fragmentManager = supportFragmentManager
        setCurrentFragment(MessageFragment.newInstance())
        viewBinding.ahTabContain.setOnNavigationItemSelectedListener {
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
}