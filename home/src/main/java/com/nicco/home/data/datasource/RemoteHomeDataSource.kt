package com.nicco.home.data.datasource

import com.nicco.home.data.retrofit.HomeCardResponse
import com.nicco.home.presentation.model.HomeCardModel
import kotlinx.coroutines.flow.Flow

interface RemoteHomeDataSource {
    suspend fun getListHome(): Flow<List<HomeCardResponse>>?
}