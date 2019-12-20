package com.lazyxu.user.ui.login

import android.view.View
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.lazyxu.base.base.BaseActivity
import com.lazyxu.base.base.head.HeadToolbar
import com.lazyxu.base.base.head.HeaderBuilder
import com.lazyxu.base.router.RouterUrl
import com.lazyxu.base.router.ArouterUtils
import com.lazyxu.base.utils.AppToast
import com.lazyxu.base.utils.Constants
import com.lazyxu.base.utils.SpUtil
import com.lazyxu.user.BR
import com.lazyxu.user.R
import com.lazyxu.user.databinding.ActivityLoginBinding

/**
 * User: Lazy_xu
 * Data: 2019/07/30
 * Description:
 * FIXME
 */
@Route(path = RouterUrl.LOGIN)
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    private var loginnextpath = ""
    override fun headToolbar(): HeadToolbar {
        return HeaderBuilder()
                .layoutId(R.layout.activity_login)
                .titleBar(R.id.commoninclude_toolbar)
                .toolbarTitle(R.string.login)
                .build()
    }

    override fun bindingVariable(): Int {
        return BR.viewModel
    }

    override fun onBindViewModel(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }

    fun onClick(view: View) {
        with(mViewModel) {
            this!!.login().observe(this@LoginActivity, Observer<Boolean> { loginSuc(it) })
        }
    }

    override fun initDatas() {
        loginnextpath = intent.getStringExtra(RouterUrl.PATH)
        mDataBinding.view = this@LoginActivity
    }


    private fun loginSuc(aBoolean: Boolean?) {
        if (aBoolean != null && aBoolean) {
            AppToast.show("登录成功")
            SpUtil.put(Constants.SP_IS_LOGIN, true)
            ArouterUtils.unInterceptorClose(this, loginnextpath)
        }
    }
}
