package com.lazyxu.base.base.callback

/**
 * User:Lazy_xu
 * Data:2019/12/09
 * Description:
 * FIXME
 */
interface PermissionListener {
    fun onGranted()
    fun onDenied(deniedPermissions: List<String>)
}
