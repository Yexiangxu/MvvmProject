package com.lazyxu.base.router

import android.app.Activity

import com.alibaba.android.arouter.launcher.ARouter

/**
 * User:Lazy_xu
 * Data:2019/12/16
 * Description:
 * FIXME
 */
object ArouterUtils {
    fun unInterceptorClose(activity: Activity, url: String) {
        ARouter.getInstance().build(url).greenChannel().navigation(activity)
        activity.finish()
    }

    fun interceptor(url: String) {
        ARouter.getInstance().build(url).greenChannel().navigation()
    }
}
