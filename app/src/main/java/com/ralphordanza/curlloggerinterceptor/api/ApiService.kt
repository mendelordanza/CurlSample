package com.ralphordanza.curlloggerinterceptor.api

import com.ralphordanza.curlloggerinterceptor.Post
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("posts")
    fun get_posts(@Query("userId") userId: Int): Call<List<Post>>
}