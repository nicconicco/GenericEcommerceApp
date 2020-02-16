package com.nicco.home.data.datasource

import com.nicco.home.data.retrofit.HomeCardApi
import com.nicco.home.data.retrofit.HomeCardResponse
import kotlinx.coroutines.delay

class RemoteHomeDataSourceImp(val homeApi: HomeCardApi): RemoteHomeDataSource {

    override suspend fun getListHome(): List<HomeCardResponse>? {
        delay(2000)
        return homeApi.getHomeCard()
    }
}