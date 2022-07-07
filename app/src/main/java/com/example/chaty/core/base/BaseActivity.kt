package com.example.chaty.core.base

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.chaty.R
import com.example.chaty.core.event.EventBusUtil
import com.example.chaty.core.util.AppHelper
import com.example.chaty.core.widget.ProgressLoading

abstract class BaseActivity : AppCompatActivity() {
    lateinit var progressLoading: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        EventBusUtil.register(this)
        Log.d("longtq", "Activity name: " + this.javaClass.simpleName)
        setStatusBarColor(Color.parseColor("#ffffff"))
        progressLoading = ProgressLoading(this)
    }

    override fun onDestroy() {
        AppHelper.hideKeyboard(this)
        EventBusUtil.unregister(this)
        super.onDestroy()
    }

    override fun finish() {
        super.finish()
        try {
            overridePendingTransition(
                R.anim.activity_slide_from_left,
                R.anim.activity_slide_to_right
            )
        } catch (e: Exception) {
            e.stackTrace
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    fun setStatusBarColor(color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = color
        }
    }

    fun openNewActivity(c: Class<*>?) {
        try {
            val intent = Intent(this, c)
            startActivity(intent)
            overridePendingTransition(R.anim.activity_come_in, R.anim.activity_come_out)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun openNewActivityAndClearStack(c: Class<*>?) {
        try {
            val intent = Intent(this, c)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            overridePendingTransition(R.anim.activity_come_in, R.anim.activity_come_out)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun openNewActivity(bundle: Bundle?, c: Class<*>?) {
        try {
            val intent = Intent(this, c)
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivity(intent)
            overridePendingTransition(R.anim.activity_come_in, R.anim.activity_come_out)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun openNewActivity(intent: Intent, bundle: Bundle?) {
        try {
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivity(intent)
            overridePendingTransition(R.anim.activity_come_in, R.anim.activity_come_out)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun openNewActivityForResult(bundle: Bundle?, c: Class<*>?) {
        try {
            val intent = Intent(this, c)
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivityForResult(intent, BASE_RESULT_CODE)
            overridePendingTransition(R.anim.activity_come_in, R.anim.activity_come_out)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun openNewActivityForResult(bundle: Bundle?, c: Class<*>?, requestcode: Int) {
        try {
            val intent = Intent(this, c)
            intent.putExtra(BUNDLE_KEY, bundle)
            startActivityForResult(intent, requestcode)
            overridePendingTransition(R.anim.activity_come_in, R.anim.activity_come_out)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun setBackButtonToolbar() {
        val mActionBarToolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mActionBarToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
    }

    fun setTitleToolbar(title: String?) {
        val mActionBarToolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mActionBarToolbar)
        mActionBarToolbar.title = title
        mActionBarToolbar.setTitleTextAppearance(this, R.style.toolbar_title)
    }


    companion object {
        const val BASE_RESULT_CODE = 8080
        const val BUNDLE_KEY = "BUNDLE_KEY"
    }
}