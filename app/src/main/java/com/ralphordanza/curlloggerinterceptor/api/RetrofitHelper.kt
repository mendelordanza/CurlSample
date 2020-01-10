package com.ralphordanza.curlloggerinterceptor.api

import com.ralphordanza.curlloggerinterceptor.CurlLoggerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    val retofitClient: Retrofit.Builder by lazy {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(CurlLoggerInterceptor("CURL"))
            .build()

        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
    }

    val apiService: ApiService by lazy {
        retofitClient
            .build()
            .create(ApiService::class.java)
    }
}