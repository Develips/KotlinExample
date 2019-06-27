package com.develips.kotlin

import android.app.Application
import com.develips.kotlin.net.HttpManager
import com.develips.kotlin.net.api.ApiService

/**
 * @Author: slp
 * @E-Mail: siilip@qq.com
 * @Created: 2019/06/25
 * @Description:
 * @Version: 1.0
 */
class App : Application(){

    private object Holder {
        val INSTANCE = App()
    }
    companion object {
        val instance by lazy { Holder.INSTANCE }
    }

    override fun onCreate() {
        super.onCreate()
    }

    fun getApiService():ApiService{
        return HttpManager.instance.init(ApiService::class.java)
    }
}