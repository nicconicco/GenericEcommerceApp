package com.nicco.home.data.retrofit

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface HomeCardApi {
    @GET("/home/home_card_list")
    suspend fun getHomeCard(): Flow<List<HomeCardResponse>>
}