package com.develips.kotlin.net

import com.develips.kotlin.BuildConfig
import com.develips.kotlin.net.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author: slp
 * @E-Mail: siilip@qq.com
 * @Created: 2019/06/25
 * @Description:
 * @Version: 1.0
 */
class HttpManager private constructor(){

//    lateinit var apiService: ApiService
//    private lateinit var retrofit:Retrofit

    private object Holder {
        val INSTANCE = HttpManager()
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
    }

    fun <T> init(service:Class<T>):T {
        val okHttpClient = OkHttpClient().newBuilder()
                .addInterceptor(initLogInterceptor())
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        //apiService = retrofit.create(ApiService::class.java)
        return retrofit.create(service)
    }

    /*
        日志拦截器
     */
    private fun initLogInterceptor():HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return interceptor
    }

//    fun <T> create(service:Class<T>):T{
//        return retrofit.create(service)
//    }
}