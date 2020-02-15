package com.nicco.home.data.repository

import com.nicco.home.data.retrofit.HomeCardResponse
import com.nicco.home.presentation.model.HomeCardModel
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getListHome(): Flow<List<HomeCardResponse>>?
}