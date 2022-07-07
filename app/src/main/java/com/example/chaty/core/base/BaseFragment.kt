package com.example.chaty.core.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.blankj.utilcode.util.FragmentUtils

abstract class BaseFragment : Fragment() {
    var isAttached = false

    open fun onBackPressed(): Boolean {
        return false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("longtq", "fragment: " + this.javaClass.simpleName)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.isAttached = true
    }

    override fun onDetach() {
        super.onDetach()
        this.isAttached = false
    }

    open fun getTAG(): String? {
        return BaseFragment::class.java.simpleName
    }

    open fun addFragment(fragment: Fragment?, @IdRes frameId: Int) {
        try {
            if (fragment != null) {
                FragmentUtils.add(childFragmentManager, fragment, frameId)
            }
        } catch (ignored: java.lang.Exception) {
        }
    }


    open fun replaceFragment(fragment: Fragment?, @IdRes frameId: Int) {
        try {
            if (fragment != null) {
                FragmentUtils.replace(childFragmentManager, fragment, frameId, true)
            }
        } catch (ignored: Exception) {
        }
    }

    open fun removeFragment(fragment: Fragment?) {
        try {
            if (fragment != null) {
                FragmentUtils.remove(fragment)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    interface OnBackPressFragmentCallBack {
        fun onBack()
    }

    open fun getBaseActivity(): BaseActivity? {
        return activity as BaseActivity?
    }
}