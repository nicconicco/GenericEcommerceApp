package com.nicco.home.data.repository

import com.nicco.home.data.datasource.RemoteHomeDataSource
import com.nicco.home.data.retrofit.HomeCardResponse
import com.nicco.home.presentation.model.HomeCardModel
import kotlinx.coroutines.flow.Flow

class HomeRepositoryImp(val rermoteHome: RemoteHomeDataSource) : HomeRepository {
    override suspend fun getListHome(): List<HomeCardResponse>? = rermoteHome.getListHome()
}