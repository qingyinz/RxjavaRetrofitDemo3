package com.example.mingyue.rxjavaretrofitdemo3.activity

import android.os.Bundle
import android.widget.Toast
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import com.example.mingyue.rxjavaretrofitdemo3.R
import com.example.mingyue.rxjavaretrofitdemo3.data.Repo
import com.example.mingyue.rxjavaretrofitdemo3.network.ApiClient
import com.example.mingyue.rxjavaretrofitdemo3.network.ApiErrorModel
import com.example.mingyue.rxjavaretrofitdemo3.network.ApiResponse
import com.example.mingyue.rxjavaretrofitdemo3.network.NetworkScheduler

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        submit.setOnClickListener { fetchRepo() } //按钮点击事件
    }
    private fun fetchRepo() {
        //链式调用
        ApiClient.instance.service.listRepos(inputUser.text.toString()) //GitHubService中的方法
                .compose(NetworkScheduler.compose())                         //线程切换处理
                .bindUntilEvent(this, ActivityEvent.DESTROY)        //生命周期管理
                .subscribe(object : ApiResponse<List<Repo>>(this) {              //对象表达式约等于Java中的匿名内部类
                    override fun success(data: List<Repo>) {                     //请求成功，此处显示一些返回的数据
                        userName.text = data[0].owner.login   //用户名
                        repoName.text = data[0].name            //仓库名
                        description.text = data[0].description  //描述
                        url.text = data[0].html_url         //url
                    }
                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        Toast.makeText(this@MainActivity, apiErrorModel.message, Toast.LENGTH_SHORT).show()
                    }
                })
    }
}