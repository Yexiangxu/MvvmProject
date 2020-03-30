package com.lazyxu.user.data

import com.lazyxu.base.data.BaseBean
import com.lazyxu.user.data.entity.db.LoginRequestModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * BaseBean<Any>
 */
interface UserApiService {
    /**
     * 检查手机号是否已注册
     */
    @POST("/app-invest/login/isRegistered")
    @Headers("Accept: application/json")
    suspend fun isRegistered(@Body loginRequestModel: LoginRequestModel): Response<BaseBean<Boolean>>

}
