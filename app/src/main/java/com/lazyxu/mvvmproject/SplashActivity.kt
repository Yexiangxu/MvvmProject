package com.lazyxu.mvvmproject

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lazyxu.base.aop.annotation.CheckNet
import com.lazyxu.base.router.ArouterUtils
import com.lazyxu.base.router.RouterUrl
import com.lazyxu.base.utils.ActivityStack
import com.lazyxu.base.aop.annotation.SingleClick
import com.lazyxu.mvvmproject.databinding.ActivitySplashBinding

/**
 * User: xuyexiang
 * Date: 2019/06/11
 * Description:
 * FIXME
 */
class SplashActivity : AppCompatActivity() {
    lateinit var mdatabinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mdatabinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        mdatabinding.view=this
    }
    @SingleClick
    @CheckNet
    fun onClick(view: View) {
        ArouterUtils.unInterceptorClose(this, RouterUrl.MAIN)
    }
    var exitTime = 0L
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {//
                // 如果两次按键时间间隔大于2000毫秒，则不退出
                Toast.makeText(this@SplashActivity, "再按退出", Toast.LENGTH_SHORT).show()
                exitTime = System.currentTimeMillis()// 更新mExitTime
            } else {
                val startMain = Intent(Intent.ACTION_MAIN)
                startMain.addCategory(Intent.CATEGORY_HOME)
                startMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(startMain)
                ActivityStack.getInstance().popAllActivity(false)
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
