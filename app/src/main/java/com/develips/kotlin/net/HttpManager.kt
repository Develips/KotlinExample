package com.develips.kotlin.net

import com.develips.kotlin.BuildConfig
import com.develips.kotlin.net.api.ApiService
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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

    lateinit var apiService: ApiService

    private object Holder {
        val INSTANCE = HttpManager()
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
    }

    fun init() {
        val okHttpClient = OkHttpClient().newBuilder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(
                        if (BuildConfig.DEBUG)
                            HttpLoggingInterceptor.Level.BODY
                        else
                            HttpLoggingInterceptor.Level.NONE
                )).build()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

        apiService = retrofit.create(ApiService::class.java)
    }
}