package com.lazyxu.user.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.lazyxu.base.router.RouterUrl
import com.lazyxu.user.R

/**
 * User:Lazy_xu
 * Data:2019/10/30
 * Description:
 * FIXME
 */
@Route(path = RouterUrl.SETTING)
class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

    }
}
