package com.ralphordanza.curlsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ralphordanza.curlsample.api.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitHelper.apiService.get_posts(1)
            .enqueue(object : Callback<List<Post>>{
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    Log.d("LIST", "post:" + response.body())
                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {

                }
            })
    }
}
