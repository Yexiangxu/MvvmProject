package com.lazyxu.user.ui.loginorregister

import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.lazyxu.base.base.BaseActivity
import com.lazyxu.base.base.head.HeadToolbar
import com.lazyxu.base.base.head.HeaderBuilder
import com.lazyxu.base.router.ArouterUtils
import com.lazyxu.base.router.RouterUrl
import com.lazyxu.base.utils.AppToast
import com.lazyxu.base.utils.UiUtils
import com.lazyxu.user.BR
import com.lazyxu.user.R
import com.lazyxu.user.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login_or_register.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 * User: Lazy_xu
 * Data: 2019/07/30
 * Description:
 * FIXME
 */
@Route(path = RouterUrl.User.LOGINORREGISTER)
class LoginOrRegisterActivity : BaseActivity<LoginOrRegisterViewModel, ActivityLoginBinding>() {
    override fun bindingVariable(): Int = BR.viewModel
    override fun initViewModel(): LoginOrRegisterViewModel = getViewModel()

    private var loginNextPath: String? = RouterUrl.User.LOGIN


    override fun headToolbar(): HeadToolbar {
        return HeaderBuilder()
                .layoutId(R.layout.activity_login_or_register)
                .backDrawable(R.drawable.login_back)
                .toolbarTitle(R.string.login_or_register_title)
                .build()
    }


    override fun initDatas() {
        loginNextPath = intent.getStringExtra(RouterUrl.PATH)
        //修改hint字体的大小
        UiUtils.setHint(etUserPhone, this.resources.getString(R.string.pls_input_phone), 13)
        mViewModel.apply {
            loginUiState.observe(this@LoginOrRegisterActivity, Observer {
                if (it.showProgress) {
                    AppToast.show("加载中")
                }
                it.showSuccess?.let {
                    AppToast.show("加载消失")
                    AppToast.show("登录成功")
                    ArouterUtils.unInterceptorClose(this@LoginOrRegisterActivity, RouterUrl.MAIN)
                }
                it.showError?.let { err ->
                    {
                        AppToast.show("加载消失")
                        AppToast.show(err)
                    }
                }
            })
        }
    }


}
