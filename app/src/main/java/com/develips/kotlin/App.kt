package com.develips.kotlin

import android.app.Application
import com.develips.kotlin.net.HttpManager

/**
 * @Author: slp
 * @E-Mail: siilip@qq.com
 * @Created: 2019/06/25
 * @Description:
 * @Version: 1.0
 */
class App : Application(){
    override fun onCreate() {
        super.onCreate()
        HttpManager.instance.init()
    }
}