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
        Observable.just(true).subscribe({ aBoolean ->
            Log.i("", "" + aBoolean!!)
            Log.i("", "")
        }, { })
    }

}
