package com.lazyxu.user.ui.login

import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.lazyxu.base.base.head.HeadToolbar
import com.lazyxu.base.base.head.HeaderBuilder
import com.lazyxu.base.router.ArouterUtils
import com.lazyxu.base.router.RouterUrl
import com.lazyxu.base.utils.AppToast
import com.lazyxu.user.BR
import com.lazyxu.user.R
import com.lazyxu.user.databinding.ActivityLoginBinding
import luyao.mvvm.core.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * User: Lazy_xu
 * Data: 2019/07/30
 * Description:
 * FIXME
 */
@Route(path = RouterUrl.User.LOGIN)
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    override fun bindingVariable(): Int = BR.viewModel
    override fun initViewModel(): LoginViewModel = getViewModel()

    private var loginNextPath: String? = RouterUrl.MAIN
    override fun headToolbar(): HeadToolbar {
        return HeaderBuilder()
                .layoutId(R.layout.activity_login)
                .titleBar(R.id.commoninclude_toolbar)
                .toolbarTitle(R.string.login)
                .build()
    }


    override fun initDatas() {
        loginNextPath = intent.getStringExtra(RouterUrl.PATH)
        mViewModel.apply {
            loginUiState.observe(this@LoginActivity, Observer {
                if (it.showProgress) {
                    //showprogress
                }
                it.showSuccess?.let {
                    AppToast.show("登录成功")
                    ArouterUtils.unInterceptorClose(this@LoginActivity, RouterUrl.MAIN)
                }
            })
        }
    }


}
