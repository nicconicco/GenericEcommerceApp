package com.nicco.home.data.repository

import com.nicco.home.data.retrofit.HomeCardResponse

interface HomeRepository {
    suspend fun getListHome(): List<HomeCardResponse>?
}