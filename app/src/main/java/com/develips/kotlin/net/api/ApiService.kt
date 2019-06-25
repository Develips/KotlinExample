package com.develips.kotlin.net.api

import com.develips.kotlin.bean.ArticlePageBean
import com.develips.kotlin.net.response.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @Author: slp
 * @E-Mail: siilip@qq.com
 * @Created: 2019/06/25
 * @Description:
 * @Version: 1.0
 */
interface ApiService {

    /**
     * 首页文章列表
     * https://www.wanandroid.com/article/list/0/json
     * @param num 页数从0开始
     * @return feed文章列表数据
     */
    @GET("article/list/{id}/json")
    fun getHomeArticle(@Path("id") id:Int): Observable<BaseResponse<ArticlePageBean>>
}