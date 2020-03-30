package com.lazyxu.base.utils.rsa

import com.orhanobut.logger.Logger

/**
 * 双重锁下kotlin
 */
class EncryptUtils private constructor() {
    private var maps: MutableMap<String, Any> = mutableMapOf()

    init {
        Logger.d("EncryptUtils初始化")
        maps.clear()

    }

    companion object {
        val INSTANCE: EncryptUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { EncryptUtils() }
    }

    fun addParameter(key: String, value: Any): EncryptUtils {
        maps[key] = value
        return INSTANCE
    }

    fun sign(): String {
       return RSAHelper.sign(getSignData())
    }

    /**
     * 生成待签名串
     */
    private fun getSignData(): String {
        val content = StringBuilder()
        maps.forEach {
            content.append("&").append(it.key).append("=").append(it.value)
        }
        //去掉首位的&
        var signSrc = content.toString()
        if (signSrc.startsWith("&")) {
            signSrc = signSrc.replaceFirst("&".toRegex(), "")
        }
        return signSrc
    }

}