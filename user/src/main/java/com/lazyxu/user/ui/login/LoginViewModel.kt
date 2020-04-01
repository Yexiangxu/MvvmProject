package com.lazyxu.user.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lazyxu.base.data.RespondResult
import com.lazyxu.base.utils.AppToast
import com.lazyxu.user.data.entity.db.User
import com.lazyxu.user.data.repository.UserRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * User: Lazy_xu
 * Data: 2019/08/05
 * Description:
 * FIXME
 */

class LoginViewModel(private val loginRepository: UserRepositoryImpl) : ViewModel() {
    var userPhone = ObservableField<String>()
    var userPassword = ObservableField<String>()
    val loginUiState = MutableLiveData<LoginUiState>()

    fun login() {
        viewModelScope.launch(Dispatchers.Main) {
            if (userPhone.get().isNullOrEmpty()) {
                AppToast.show("请输入用户名")
                return@launch
            }
            if (userPassword.get().isNullOrEmpty()) {
                AppToast.show("请输入密码")
                return@launch
            }
            emitUiState(showProgress = true)
//            val result = withContext(Dispatchers.IO) {
//                loginRepository.login(userPhone.get() ?: "", userPassword.get() ?: "")
//            }
//            checkResult(result,
//                    { emitUiState(showSuccess = it, enableLoginButton = true) },
//                    { emitUiState(showError = it, enableLoginButton = true) })

        }
    }

    val verifyInput: ((String) -> Unit)? = { loginEnableJudge() }
    private fun loginEnableJudge() {
        emitUiState(enableLoginButton = isInputValid(userPhone.get() ?: "", userPassword.get()
                ?: ""))
    }

    private fun isInputValid(userName: String, passWord: String) = userName.isNotBlank() && passWord.isNotBlank()
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
            showSuccess: User? = null,
            enableLoginButton: Boolean = false,
            needLogin: Boolean = false
    ) {
        val uiModel = LoginUiState(showProgress, showError, showSuccess, enableLoginButton, needLogin)
        loginUiState.value = uiModel
    }
}

data class LoginUiState(val showProgress: Boolean,
                        val showError: String?,
                        val showSuccess: User?,
                        val enableLoginButton: Boolean,
                        val needLogin: Boolean)
