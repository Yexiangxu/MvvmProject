package com.lazyxu.base.data

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.lazyxu.base.BuildConfig
import com.lazyxu.base.utils.LogUtil
import okhttp3.Cache
import okhttp3.CookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.Proxy
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/*
 * User:lazy_xu
 * Data: 2020/1/7
 * Description:
 * FIXME
 */
const val CONNECT_TIME_OUT: Long = 60

fun retrofit(context: Context, API_BASE_URL: String = "https://app.api.mmtvip.com"): Retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .client(initOkhttp(context))
        .addConverterFactory(GsonConverterFactory.create())
        .build()





private fun initOkhttp(context: Context): OkHttpClient {
    val sslContext = SSLContext.getInstance("TLS")
    sslContext.init(null, trustAllCerts, SecureRandom())
    val sslSocketFactory = sslContext.socketFactory
    return OkHttpClient.Builder()
            .proxy(Proxy.NO_PROXY) //禁止代理防止抓包
            .cache(Cache(context.cacheDir, (1024 * 1024 * 20).toLong()))
            .cookieJar(cookieJar(context))
            .addInterceptor(initLogInterceptor())
//        .retryOnConnectionFailure(true)//失败重试一次 比较关键   cookie  header
            .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
            .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)//绕过证书
            .hostnameVerifier(HostnameVerifier { _, _ -> true })
            .build()
}

internal val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
    @SuppressLint("TrustAllX509TrustManager")
    @Throws(CertificateException::class)
    override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
    }

    @SuppressLint("TrustAllX509TrustManager")
    @Throws(CertificateException::class)
    override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
    }

    override fun getAcceptedIssuers(): Array<X509Certificate> {
        return arrayOf()
    }
})


private fun cookieJar(context: Context): CookieJar {
    return PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(context))
}

private fun initLogInterceptor(): HttpLoggingInterceptor {
    //log查看网络请求（请求参数、返回结果、网络请求时长等信息）
    return HttpLoggingInterceptor { message -> Log.d(LogUtil.HTTPLOG, message) }.setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
}

