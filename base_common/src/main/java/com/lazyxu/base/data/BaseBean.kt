package com.lazyxu.base.data

/**
 * Created by Administrator on 2016/5/24.
 * 封装 error，msg，date
 */
data class BaseBean<out T>(val errorCode: Int, val errorMsg: String, val data: T)