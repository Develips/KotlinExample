package com.develips.kotlin.net.observer

import com.develips.kotlin.net.response.BaseResponse
import com.google.gson.JsonSyntaxException
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

/**
 * @Author: slp
 * @E-Mail: siilip@qq.com
 * @Created: 2019/06/25
 * @Description:   BaseResponse
 * @Version: 1.0
 */
abstract class BaseResponseCallback<T> : Observer<BaseResponse<T>> {

    /**可以实现 LoadingDialog */

    abstract fun success(data: T)
    abstract fun failure(errorCode: Int, errorMsg: String)

    private object Status {
        const val SUCCESS = 0
    }

    override fun onSubscribe(d: Disposable) {
        //LoadingDialog.show()
    }

    override fun onNext(t: BaseResponse<T>) {
        if (t.errorCode == Status.SUCCESS) {
            success(t.data)
            return
        }else{
            /** 可以根据返回的Code做全局提示 */
            failure(t.errorCode, t.errorMsg)
        }
    }

    override fun onComplete() {
        //LoadingDialog.cancel()
    }

    override fun onError(e: Throwable) {
        //LoadingDialog.cancel()
        println(e)
        if (e is ConnectException || e is UnknownHostException) {
            failure(400, "网络未连接")
        } else if (e is SecurityException) {
            failure(400, "呀,好像忘记配置权限了")
        }else if (e is TimeoutException || e is SocketTimeoutException) {
            failure(400, "网络超时")
        } else if (e is JsonSyntaxException) {
            failure(400, "数据解析异常")
        } else {
            failure(400, "未知异常")
        }
    }
}
