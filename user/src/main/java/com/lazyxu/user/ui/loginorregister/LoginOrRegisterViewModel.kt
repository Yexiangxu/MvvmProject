package com.lazyxu.user.ui.loginorregister

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lazyxu.base.aop.annotation.CheckNet
import com.lazyxu.base.data.RespondResult
import com.lazyxu.base.utils.StringFormatUtil
import com.lazyxu.base.utils.rsa.EncryptUtils
import com.lazyxu.user.data.repository.UserRepositoryImpl
import kotlinx.coroutines.launch

/**
 * User: Lazy_xu
 * Data: 2019/08/05
 * Description:
 * FIXME
 */

class LoginOrRegisterViewModel(val loginRepository: UserRepositoryImpl) : ViewModel() {
    var userPhone = ObservableField<String>()
    //LiveData在实体类里可以通知指定某个字段的数据更新
    val loginUiState: LiveData<LoginOrRegisterUiState>
        get() = _loginUiState
    //MutableLiveData则是完全是整个实体类或者数据类型变化后才通知.不会细节到某个字段
    private val _loginUiState = MutableLiveData<LoginOrRegisterUiState>()


    @CheckNet
    fun login() {
        viewModelScope.launch {
            emitUiState(showProgress = true)
            userPhone.get()?.let {
                val sign = EncryptUtils.INSTANCE.addParameter("mobile", it).sign()
                val result = loginRepository.login(sign, it)
                checkResult(result,
                        { emitUiState(showSuccess = false) },
                        { emitUiState(showError = it) })

            }
        }
    }

    val verifyInput: (String) -> Unit = { loginEnableJudge() }
    private fun loginEnableJudge() {
        emitUiState(enableLoginButton = isInputValid(userPhone.get()))
    }

    private fun isInputValid(userName: String?) = StringFormatUtil.replaceBlank(userName).length == 11


    private inline fun <T : Any> checkResult(result: RespondResult<T>, success: (T) -> Unit, error: (String?) -> Unit) {
        if (result is RespondResult.Success) {
            success(result.data)
        } else if (result is RespondResult.Error) {
            error(result.exception.message)
        }
    }

    private fun emitUiState(
            showProgress: Boolean = false,
            showError: String? = null,
            showSuccess: Boolean? = false,
            enableLoginButton: Boolean = false
    ) {
        val uiModel = LoginOrRegisterUiState(showProgress, showError, showSuccess, enableLoginButton)
        //setValue()只能在主线程中调用，postValue()可以在任何线程中调用
        _loginUiState.value = uiModel
    }
}

data class LoginOrRegisterUiState(val showProgress: Boolean,
                                  val showError: String?,
                                  val showSuccess: Boolean?,
                                  val enableLoginButton: Boolean)
