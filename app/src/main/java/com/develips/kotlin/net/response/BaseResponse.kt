package com.develips.kotlin.net.response

/**
 * @Author: slp
 * @E-Mail: siilip@qq.com
 * @Created: 2019/06/25
 * @Description:
 * @Version: 1.0
 */
data class BaseResponse <T>(var data: T, var errorCode: Int, var errorMsg: String)