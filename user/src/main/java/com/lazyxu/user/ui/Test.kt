package com.lazyxu.user.ui


import android.util.Log

import io.reactivex.Observable
import io.reactivex.functions.Consumer

/**
 * User: Lazy_xu
 * Data: 2019/07/30
 * Description:
 * FIXME
 */

object Test {
    fun test() {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return
            print(it) // 12  没标签返回出main方法
        }
    }
}
