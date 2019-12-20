package com.lazyxu.base.di.module


import android.app.Application
import android.util.Log
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.lazyxu.base.BuildConfig
import com.lazyxu.base.Config
import com.lazyxu.base.utils.LogUtil
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.Proxy
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author xuyexiang
 */
@Module
class HttpModule {


    /**
     * @return HttpLoggingInterceptor 供下面 provideOkHttpClient 方法使用
     */
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        //log查看网络请求（请求参数、返回结果、网络请求时长等信息）
        return HttpLoggingInterceptor { message -> Log.d(LogUtil.HTTPLOG, message) }.setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
    }

    /**
     * @return OkHttpClient 供下面 provideRetrofit 方法使用
     */
    @Singleton
    @Provides
    fun provideOkHttpClient(application: Application, httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
//                .proxy(Proxy.NO_PROXY) //禁止代理防止抓包
                .cache(Cache(application.cacheDir, (1024 * 1024 * 50).toLong()))
                .connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .addNetworkInterceptor(StethoInterceptor())
                .addNetworkInterceptor(httpLoggingInterceptor).build()
    }

    /**
     * @return Retrofit 供下面 provideMineApiService 方法使用
     */
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Config.HOST)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }
}


