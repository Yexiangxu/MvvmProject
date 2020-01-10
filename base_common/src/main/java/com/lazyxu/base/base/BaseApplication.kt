package com.lazyxu.base.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.facebook.stetho.Stetho
import com.lazyxu.base.BuildConfig
import com.lazyxu.base.utils.DeviceUtil
import com.lazyxu.base.utils.ScreenAdapterUtil
import com.lazyxu.base.utils.SpUtilDelete
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.squareup.leakcanary.LeakCanary

/*
 * User:lazy_xu
 * Data: 2020/1/7
 * Description:
 * FIXME
 */
open class BaseApplication : Application() {
    companion object {
        lateinit var INSTANCE: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        if (packageName == DeviceUtil.processName) {
            initDebug()
            SpUtilDelete.init(this)
            ScreenAdapterUtil.setDensity(this, 360f)
        }
        ARouter.init(INSTANCE)
    }

    private fun initDebug() {
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(AndroidLogAdapter())
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()
            ARouter.openDebug()
            if (LeakCanary.isInAnalyzerProcess(this)) {
                return
            }
            LeakCanary.install(this)
            Stetho.initializeWithDefaults(this)
        }
    }
}