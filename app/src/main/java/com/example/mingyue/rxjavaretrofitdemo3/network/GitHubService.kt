package com.example.mingyue.rxjavaretrofitdemo3.network


import com.example.mingyue.rxjavaretrofitdemo3.data.Repo
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by leimo on 2018/12/28.
 */
interface GitHubService {
    //请添加相应的`API`调用方法
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Observable<List<Repo>>//每个方法的返回值即一个Observable

}




