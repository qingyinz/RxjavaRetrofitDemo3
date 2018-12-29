package com.example.mingyue.rxjavaretrofitdemo3.util

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File


/**
 * Created by leimo on 2018/12/28.
 */
object OkHttpUtil {
    fun createTextRequestBody(source: String): RequestBody
            = RequestBody.create(MediaType.parse("text/plain"), source)

    fun createPartWithAllImageFormats(requestKey: String, file: File): MultipartBody.Part
            = MultipartBody.Part
            .createFormData(requestKey, file.name, RequestBody.create(MediaType.parse("image/*"), file))
}