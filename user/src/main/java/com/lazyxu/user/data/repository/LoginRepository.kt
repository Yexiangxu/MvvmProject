package com.lazyxu.user.data.repository

import com.lazyxu.base.data.BaseRepository
import com.lazyxu.base.data.RespondResult
import com.lazyxu.base.utils.SpUtils
import com.lazyxu.user.data.UserApiService
import com.lazyxu.user.data.entity.db.User

/**
 * Created by luyao
 * on 2019/4/10 9:42
 */
class LoginRepository(val service: UserApiService) : BaseRepository() {

    private var isLogin by SpUtils(SpUtils.IS_LOGIN, false)

    suspend fun login(userName: String, passWord: String): RespondResult<User> {
        return safeApiCall(call = { requestLogin(userName, passWord) }, errorMessage = "登录失败!")
    }

    private suspend fun requestLogin(userName: String, passWord: String): RespondResult<User> {
        isLogin = true
        val response = service.login(userName, passWord)

        return executeResponse(response, { response.data })
    }
}