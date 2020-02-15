package com.nicco.home.data.retrofit

import retrofit2.http.GET

interface HomeCardApi {
    @GET("/home/home_card_list")
    suspend fun getHomeCard(): List<HomeCardResponse>
}