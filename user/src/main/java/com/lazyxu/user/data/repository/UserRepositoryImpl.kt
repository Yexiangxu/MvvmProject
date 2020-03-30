package com.lazyxu.user.data.repository

import com.lazyxu.base.data.BaseBean
import com.lazyxu.user.data.UserApiService
import com.lazyxu.user.data.entity.db.LoginRequestModel
import retrofit2.Response

/**
 * Created by luyao
 * on 2019/4/10 9:42
 */
class UserRepositoryImpl(val service: UserApiService) : UserRepository() {
    override suspend fun isRegistered(loginRequestModel: LoginRequestModel): Response<BaseBean<Boolean>> {
        service.isRegistered(loginRequestModel)
    }


}