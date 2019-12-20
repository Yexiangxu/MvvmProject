package com.lazyxu.base.base

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.gyf.immersionbar.ImmersionBar
import com.lazyxu.base.R
import com.lazyxu.base.base.callback.PermissionListener
import com.lazyxu.base.base.head.HeadToolbar
import com.lazyxu.base.utils.ActivityStack
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import java.util.*
import javax.inject.Inject

/**
 * User: Lazy_xu
 * Data: 2019/07/05
 * Description:
 * FIXME
 */
abstract class BaseActivity<V : AndroidViewModel, B : ViewDataBinding> : DaggerAppCompatActivity(), IBaseView {
    var mViewModel: V? = null
    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory
    lateinit var mDataBinding: B
    private var mLayoutId: Int = 0
    private var mTitleBar: Int = 0
    private var mToolbar: Toolbar? = null
    private var mToolbarTitle: Int = 0
    private var mBackDrawable: Int = 0
    private var mToolbarTitleColor: Int = 0

    abstract fun headToolbar(): HeadToolbar

    abstract fun bindingVariable(): Int
    /**
     * ViewModelProviders 工具类帮助创建 ViewModel
     */
    val viewModel: V
        get() = ViewModelProviders.of(this, mViewModelFactory).get(onBindViewModel())

    protected fun setupToolbar() {
        setSupportActionBar(mToolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onDestroy() {
        super.onDestroy()
        ActivityStack.getInstance().removeActivity(this)
    }

    private fun initDatabinding() {
        mDataBinding = DataBindingUtil.setContentView(this, mLayoutId)
        this.mViewModel = if (mViewModel == null) viewModel else mViewModel
        mDataBinding.setVariable(bindingVariable(), mViewModel)
        //当数据改变时，binding会在下一帧去改变数据，如果我们需要立即改变，就去调用executePendingBindings
        mDataBinding.executePendingBindings()
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isTaskRoot) { //防止首次安装按home键重新启动
            val intent = intent
            val action = intent.action
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && action == Intent.ACTION_MAIN) {
                finish()
                return
            }
        }
        ActivityStack.getInstance().addActivity(this)
        initHeader()
        initDatabinding()
        initToolbar()
        initStatusBar()
        initDatas()
    }

    private fun initStatusBar() {
        if (mToolbar != null) {
            ImmersionBar.with(this).titleBar(mTitleBar).init()
        } else {
            ImmersionBar.with(this).init()
        }
    }

    private fun initToolbar() {
        if (mTitleBar != -1) {
            if (findViewById<View>(mTitleBar) is Toolbar) {
                mToolbar = findViewById(mTitleBar)
                setSupportActionBar(mToolbar)
                if (supportActionBar != null) {
                    supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                    //设置返回图标
                    if (mBackDrawable != -1) {
                        supportActionBar!!.setHomeAsUpIndicator(mBackDrawable)
                    }
                    mToolbar!!.setNavigationOnClickListener { finish() }
                    //                  getSupportActionBar().setDisplayShowTitleEnabled(false);//隐藏居左标题,暂留用来处理标题居中和居左两种情况
                    if (mToolbarTitle != -1) {
                        supportActionBar!!.setTitle(mToolbarTitle)
                    }
                    if (mToolbarTitleColor != -1) {
                        mToolbar!!.setTitleTextColor(ContextCompat.getColor(this, mToolbarTitleColor))
                    }
                }
            }
        }
    }


    private fun initHeader() {
        val headToolbar = headToolbar()
        mLayoutId = headToolbar.layoutId
        mTitleBar = headToolbar.titleBar
        mToolbarTitle = headToolbar.toolbarTitle
        mBackDrawable = headToolbar.backDrawable
        mToolbarTitleColor = headToolbar.toolbarTitleColor
    }


    abstract fun onBindViewModel(): Class<V>

    protected abstract fun initDatas()

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * 点击非edittext处软键盘消失
     */
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (isShouldHideInput(v, ev)) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                assert(v != null)
                imm.hideSoftInputFromWindow(v!!.windowToken, 0)
            }
            return super.dispatchTouchEvent(ev)
        }        // 必不可少，否则所有的组件都不会有TouchEvent了
        return if (window.superDispatchTouchEvent(ev)) {
            true
        } else onTouchEvent(ev)
    }

    private fun isShouldHideInput(v: View?, event: MotionEvent): Boolean {
        if (v is EditText) {
            val leftTop = intArrayOf(0, 0)
            v.getLocationInWindow(leftTop)
            val left = leftTop[0]
            val top = leftTop[1]
            val bottom = top + v.height
            val right = left + v.width
            return !(event.x > left && event.x < right && event.y > top && event.y < bottom)
        }
        return false
    }

    /**
     * 隐藏软键盘。
     */
    fun hideSoftKeyboard() {
        try {
            val view = currentFocus
            if (view != null) {
                val binder = view.windowToken
                val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                manager.hideSoftInputFromWindow(binder, InputMethodManager.HIDE_NOT_ALWAYS)
            }
        } catch (e: Exception) {
        }

    }

    /**
     * 显示软键盘。
     */
    fun showSoftKeyboard(editText: EditText?) {
        try {
            if (editText != null) {
                editText.requestFocus()
                val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                manager.showSoftInput(editText, 0)
            }
        } catch (e: Exception) {
        }

    }

    private var mListener: PermissionListener? = null
    protected fun handlePermissions(permissions: Array<String>?, listener: PermissionListener) {
        if (permissions == null) {
            return
        }
        mListener = listener
        val requestPermissionList = ArrayList<String>()
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                requestPermissionList.add(permission)
            }
        }
        if (requestPermissionList.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, requestPermissionList.toTypedArray(), 1)
        } else {
            listener.onGranted()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> if (grantResults.isNotEmpty()) {
                val deniedPermissions = ArrayList<String>()
                for (i in grantResults.indices) {
                    val grantResult = grantResults[i]
                    val permission = permissions[i]
                    if (grantResult != PackageManager.PERMISSION_GRANTED) {
                        deniedPermissions.add(permission)
                    }
                }
                if (deniedPermissions.isEmpty()) {
                    mListener!!.onGranted()
                } else {
                    mListener!!.onDenied(deniedPermissions)
                }
            }
            else -> {
            }
        }
    }

}
