package com.lazyxu.user.data

import com.lazyxu.base.utils.RxUtils
import com.lazyxu.user.data.entity.LoginBean
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * impl 子包中一般存放 仓储中的实现类
 */
class UserRepositoryImp @Inject
constructor(private val userApiService: UserApiService) : UserRepository {
    override fun login(username: String, password: String): Flowable<LoginBean> {
        return userApiService.login(username, password).compose(RxUtils.rxSchedulerHelper())
    }

    override fun register(username: String, password: String, repassword: String): Flowable<LoginBean> {
        return userApiService.register(username, password, repassword).compose(RxUtils.rxSchedulerHelper())
    }

}


