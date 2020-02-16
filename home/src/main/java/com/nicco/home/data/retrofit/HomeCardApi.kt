package com.nicco.home.data.retrofit

import retrofit2.http.GET

interface HomeCardApi {
    @GET("homeCard")
    suspend fun getHomeCard(): List<HomeCardResponse>
}