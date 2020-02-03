package com.nicco.home.data.retrofit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CallRetrofit {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://rockon-37ff4.firebaseio.com") //url of firebase app
        .addConverterFactory(GsonConverterFactory.create()) //use for convert JSON file into object
        .build()
    var api = retrofit.create(Api::class.java) //use of interface

    fun sendPutMethod() {
        val call1: Call<HomeCardRequest> = api.setDataWithoutRandomness("sushil", HomeCardRequest("sushil", "mumbai"))
        call1.enqueue(object : Callback<HomeCardRequest?> {
            override fun onFailure(call: Call<HomeCardRequest?>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<HomeCardRequest?>,
                response: Response<HomeCardRequest?>
            ) {

            }

        })
    }
}