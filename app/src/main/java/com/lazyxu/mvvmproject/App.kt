package com.lazyxu.mvvmproject

import com.lazyxu.base.base.BaseApplication
import com.lazyxu.user.di.mineModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/*
 * User:lazy_xu
 * Data: 2020/1/7
 * Description:
 * FIXME
 */
class App : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(mineModule)
        }
    }
}