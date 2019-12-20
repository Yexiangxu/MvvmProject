package com.lazyxu.user.ui.login

import android.app.Application
import android.text.TextUtils
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.lazyxu.base.base.BaseViewModel
import com.lazyxu.base.utils.AppToast
import com.lazyxu.user.data.UserUseCase
import javax.inject.Inject

/**
 * User: Lazy_xu
 * Data: 2019/08/05
 * Description:
 * FIXME
 */

class LoginViewModel
@Inject
constructor(application: Application, private val userUseCase: UserUseCase) : BaseViewModel(application) {
    var userPhone = ObservableField<String>()
    var userPassword = ObservableField<String>()
    private val loginData = MutableLiveData<Boolean>()
    fun login(): MutableLiveData<Boolean> {
        if (!judgeLogin()) {
            loginData.value = false
            return loginData
        } else {
            addSubscribe(userUseCase.login(userPhone.get()!!, userPassword.get()!!).subscribe({ loginBean ->

                //                userUseCase.queryUser().subscribe({ user ->
//                    if (user == null ) {
//                        Log.i("LoginViewModel", "user=${user.toString()}")
//                    } else {
//                        Log.i("LoginViewModel", "user=$user")
//                    }
//                })
//                userUseCase.insertUser(loginBean.loginData)
                loginData.value = true
            }, { throwable ->
                Log.i("LoginViewModel", "throwable=$throwable")
                loginData.value = false
            }))
        }
        return loginData
    }

    private fun judgeLogin(): Boolean {
        if (TextUtils.isEmpty(userPhone.get())) {
            AppToast.show("请输入用户名")
            return false
        }
        if (TextUtils.isEmpty(userPassword.get())) {
            AppToast.show("请输入密码")
            return false
        }
        return true
    }
}