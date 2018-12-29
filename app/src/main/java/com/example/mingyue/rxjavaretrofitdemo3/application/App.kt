package com.example.mingyue.rxjavaretrofitdemo3.application

import android.app.Application
import com.example.mingyue.rxjavaretrofitdemo3.network.ApiClient

/**
 * Created by leimo on 2018/12/29.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ApiClient.instance.init()
    }
}