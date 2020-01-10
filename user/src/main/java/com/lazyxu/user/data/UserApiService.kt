package com.lazyxu.user.data

import com.lazyxu.base.data.BaseBean
import com.lazyxu.user.data.entity.db.User
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserApiService {
    /**
     * 玩安卓登录
     *
     * @param username 用户名
     * @param password 密码
     */
    @FormUrlEncoded
    @POST("https://www.wanandroid.com/user/login")
    suspend fun login(@Field("username") username: String, @Field("password") password: String): BaseBean<User>
//    /**
//     * 玩安卓注册
//     */
//    @FormUrlEncoded
//    @POST("https://www.wanandroid.com/user/register")
//    fun register(@Field("username") username: String, @Field("password") password: String, @Field("repassword") repassword: String): Flowable<LoginBean>


}
