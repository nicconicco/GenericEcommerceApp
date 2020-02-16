package com.nicco.home.data.retrofit

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface HomeCardApi {
    @GET("homeCard")
    suspend fun getHomeCard(): Flow<List<HomeCardResponse>>
}