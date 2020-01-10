package com.ralphordanza.curlsample.api

import com.ralphordanza.curlsample.Post
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("posts")
    fun get_posts(@Query("userId") userId: Int): Call<List<Post>>
}