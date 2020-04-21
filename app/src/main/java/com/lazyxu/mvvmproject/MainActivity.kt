package com.lazyxu.mvvmproject

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.afollestad.materialdialogs.MaterialDialog
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.lazyxu.base.router.RouterUrl
import com.lazyxu.base.utils.*
import com.lazyxu.mvvmproject.databinding.ActivityMainBinding
import com.lazyxu.mvvmproject.databinding.NavHeaderMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.*

/**
 * User:Lazy_xu
 * Data:2019/12/03
 * Description:
 * FIXME 1.加载效果 2.EventBus
 */
@Route(path = RouterUrl.MAIN)
open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mDatabinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        mDatabinding.view = this
        initDrawerLayout()

    }


    private lateinit var navBinding: NavHeaderMainBinding
    override fun onResume() {
        super.onResume()
//        getClipContent()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_search) {
            ARouter.getInstance().build(RouterUrl.SEARCH).navigation(this)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * 获取剪切板链接
     */
    private fun getClipContent() {
        val clipContent = CommonUtils.getClipContent()
        if (!TextUtils.isEmpty(clipContent)) {
            MaterialDialog(this).show {
                message(text = clipContent)
                positiveButton(text = "打开链接") {
                    ARouter.getInstance().build(RouterUrl.WEBVIEWMAIN).withString("webUrl", clipContent).navigation(this@MainActivity)
//                    CommonUtils.clearClipboard()
                }
            }
        }
    }


    private fun initDrawerLayout() {
        val headerView = navigationView.getHeaderView(0)
        navBinding = DataBindingUtil.bind(headerView)!!
        navBinding.view = this
    }

    fun onClick(view: View) {
        when (view) {
            llTitleMenu -> {
                drawerLayout.openDrawer(GravityCompat.START)
            }
            tvUserName -> {
                ARouter.getInstance().build(RouterUrl.User.ABOUTUS).navigation()
            }
            llSetting -> {
                ARouter.getInstance().build(RouterUrl.User.SETTING).navigation(this)
            }
            llFeedback->{
                ARouter.getInstance().build(RouterUrl.User.ABOUTUS).navigation(this)
            }
            llNavExit -> {
                SpUtilDelete.remove(Constants.SP_IS_LOGIN)
            }
        }
    }

    private var exitTime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else
                if ((System.currentTimeMillis() - exitTime) > 2000) {
                    AppToast.show(R.string.exit_hint)
                    exitTime = System.currentTimeMillis()
                } else {
                    val startMain = Intent(Intent.ACTION_MAIN)
                    startMain.addCategory(Intent.CATEGORY_HOME)
                    startMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(startMain)
                    //需要所有的Activity继承BaseActivity
                    ActivityStack.INSTANCE.popAllActivity(false)
                }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
