package com.lazyxu.base.data

/**
 * Created by luyao
 * on 2019/10/12 11:08
 */
sealed class RespondResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : RespondResult<T>()
    data class Error(val exception: Exception) : RespondResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[model=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}