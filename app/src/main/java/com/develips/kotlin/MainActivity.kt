package com.develips.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.develips.kotlin.bean.ArticlePageBean
import com.develips.kotlin.net.HttpManager
import com.develips.kotlin.net.api.ApiService
import com.develips.kotlin.net.observer.BaseResponseCallback
import com.develips.kotlin.net.transformer.NetworkScheduler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_http.setOnClickListener{
            getData()
        }
    }

    private fun getData() {
//        HttpManager.instance.init(ApiService::class.java)
//                .getHomeArticle(0)
//                .compose(NetworkScheduler.baseCompose())
//                .subscribe(object : BaseResponseCallback<ArticlePageBean>(){
//                    override fun success(data: ArticlePageBean) {
//                        tv.text = data.toString()
//                    }
//
//                    override fun failure(errorCode: Int, errorMsg: String) {
//                        tv.text = errorMsg
//                    }
//                })

        App.instance.getApiService()
                .getHomeArticle(0)
                .compose(NetworkScheduler.baseCompose())
                .subscribe(object : BaseResponseCallback<ArticlePageBean>(){
                    override fun success(data: ArticlePageBean) {
                        tv.text = data.toString()
                    }

                    override fun failure(errorCode: Int, errorMsg: String) {
                        tv.text = errorMsg
                    }
                })

//        HttpManager.instance
//                .apiService.getHomeArticle(0)
//                .compose(NetworkScheduler.baseCompose())
//                .subscribe(object : BaseResponseCallback<ArticlePageBean>(){
//                    override fun success(data: ArticlePageBean) {
//                        tv.text = data.toString()
//                    }
//
//                    override fun failure(errorCode: Int, errorMsg: String) {
//                        tv.text = errorMsg
//                    }
//                })
    }
}
