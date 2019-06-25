package com.develips.kotlin.net.transformer

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @Author: slp
 * @E-Mail: siilip@qq.com
 * @Created: 2019/06/25
 * @Description:
 * @Version: 1.0
 */
object NetworkScheduler {
    fun <T> baseCompose(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        }
    }
}