package com.lazyxu.base.data

//协变 out：类将泛型作为内部方法的返回（类型向上转换，像java中的子类向父类转换）
//逆变 in： 类将泛型作为函数的参数（类型向下转换，父类向子类转换）
data class BaseBean<out T>(val code: Int? = 0, val errorMsg: String? = "", val data: T? = null, val sign: String? = "")
