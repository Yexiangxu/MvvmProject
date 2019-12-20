package com.lazyxu.user.data

import com.lazyxu.user.data.db.AppDbHelper
import com.lazyxu.user.data.db.DbHelper
import com.lazyxu.user.data.entity.LoginBean
import com.lazyxu.user.data.entity.db.User
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * 用例
 */
class UserUseCase @Inject constructor(private val userRepository: UserRepository, private val dbHelper: AppDbHelper) : UserRepository, DbHelper {
    override fun queryUser(): Observable<User> {
        return dbHelper.queryUser()
    }

    override fun insertUser(user: User?): Observable<Boolean> {
        return dbHelper.insertUser(user)
    }



    override fun register(username: String, password: String, repassword: String): Flowable<LoginBean> {
        return userRepository.register(username, password, repassword)
    }

    override fun login(username: String, password: String): Flowable<LoginBean> {
        return userRepository.login(username, password)
    }
}



