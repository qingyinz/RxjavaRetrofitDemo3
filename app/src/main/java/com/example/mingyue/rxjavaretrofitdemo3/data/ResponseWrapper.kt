package com.example.mingyue.rxjavaretrofitdemo3.data

/**
 * Created by leimo on 2018/12/28.
 */
data class ResponseWrapper<T>(var code: Int, var data: T, var message: String)