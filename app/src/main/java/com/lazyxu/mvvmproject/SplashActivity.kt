package com.lazyxu.mvvmproject

import android.app.Activity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lazyxu.base.aop.annotation.CheckNet
import com.lazyxu.base.router.ArouterUtils
import com.lazyxu.base.router.RouterUrl
import com.lazyxu.mvvmproject.databinding.ActivitySplashBinding
import kotlinx.android.synthetic.main.activity_splash.*


/**
 * User: xuyexiang
 * Date: 2019/06/11
 * Description:
 * FIXME
 */
class SplashActivity : Activity() {
    private lateinit var mdatabinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mdatabinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        mdatabinding.view = this
        countDownTimer.start()
    }

    @CheckNet
    fun onClick(view: View) {
        jumpMain()
    }

    private fun jumpMain() {
//        ArouterUtils.unInterceptorClose(this, RouterUrl.GUIDE)
    }


    private val countDownTimer = object : CountDownTimer(3000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val value = ((millisUntilFinished / 1000) + 1).toInt().toString()
            tvSkip.text = value.plus(resources.getString(R.string.s_skip))
        }

        override fun onFinish() {
            jumpMain()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer.cancel()
    }
}
