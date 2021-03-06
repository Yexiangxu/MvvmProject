package com.lazyxu.base.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.alibaba.android.arouter.launcher.ARouter
import com.gyf.immersionbar.ktx.immersionBar
import com.lazyxu.base.R
import com.lazyxu.base.base.head.HeadToolbar
import com.lazyxu.base.utils.ActivityStack
import kotlinx.android.synthetic.main.include_toolbar_center.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

/**
 * Created by luyao
 * on 2019/12/18 14:46
 * TODO VM可以默认不设置吗
 */
abstract class BaseActivity<VM : ViewModel, DB : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var mViewModel: VM
    private val mDataBinding: DB by lazy { DataBindingUtil.setContentView<DB>(this, mLayoutId) }
    private var mLayoutId: Int = 0
    //    private var mToolBarRes: Int = -1
    private var mToolBar: Toolbar? = null
    private var mToolbarTitle: Any? = null
    private var mBackDrawable: Int = 0
    private var mToolbarTitleColor: Int = 0
    override fun onDestroy() {
        super.onDestroy()
        ActivityStack.INSTANCE.removeActivity(this)
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
        ActivityStack.INSTANCE.addActivity(this)
        ARouter.getInstance().inject(this)
        initHeader()
        initDatabinding()
        initToolbar()
        initStatusBar()
        initDatas()
    }

    private fun initHeader() {
        val headToolbar = headToolbar()
        mLayoutId = headToolbar.layoutId
        //这里设置 mToolbarTitle 必须要使用通用标题的toolbar，若个别页面不使用include的toolbar则不能在这里设置 mToolbarTitle
        mToolbarTitle = headToolbar.toolbarTitle
        mBackDrawable = headToolbar.backDrawable
        mToolbarTitleColor = headToolbar.toolbarTitleColor
    }

    abstract fun headToolbar(): HeadToolbar
    abstract fun bindingVariable(): Int
    abstract fun initViewModel(): VM
    abstract fun initDatas()
    private fun initDatabinding() {
        mViewModel = initViewModel()
        mDataBinding.setVariable(bindingVariable(), mViewModel)
        //当数据改变时，binding会在下一帧去改变数据，如果我们需要立即改变，就去调用executePendingBindings
        mDataBinding.executePendingBindings()
        mDataBinding.lifecycleOwner = this
    }

    private fun initStatusBar() {
        immersionBar {
            //若要实现qq类状态栏和标题栏渐变 不能设置 statusBarColor
//            statusBarColor(R.color.statusbarColor)
            if (mToolBar != null) {
                titleBar(mToolBar)

            }
        }
    }

    private fun initToolbar() {
        if (mToolbarTitle != -1) {
            mToolBar = centerToolbar
            mToolBar?.apply { setToolBar(this) }
        }
    }

    private fun setToolBar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false)//是否显示，自定义居中这里不能显示(隐藏居左标题,暂留用来处理标题居中和居左两种情况)
            actionBar.setDisplayHomeAsUpEnabled(true)//是否显示返回键
            if (mBackDrawable != -1) {
                actionBar.setHomeAsUpIndicator(mBackDrawable)
            } else {
                actionBar.setHomeAsUpIndicator(R.drawable.icon_back)
            }
        }
        if (mToolbarTitle != -1) {
            // supportActionBar!!.setTitle(mToolbarTitle)
            if (mToolbarTitle is String) {
                tvTitleCenter.text = mToolbarTitle as String
            } else if (mToolbarTitle is Int) {
                tvTitleCenter.text = resources.getString(mToolbarTitle as Int)
            }
        }
        if (mToolbarTitleColor != -1) {
            // mToolBar!!.setTitleTextColor(ContextCompat.getColor(this, mToolbarTitleColor))
            tvTitleCenter.setTextColor(ContextCompat.getColor(this, mToolbarTitleColor))
        }
        toolbar.setNavigationOnClickListener {
            supportFinishAfterTransition()//和 finish() 区别
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
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
}