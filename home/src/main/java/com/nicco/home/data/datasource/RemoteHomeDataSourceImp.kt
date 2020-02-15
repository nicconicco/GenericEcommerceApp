package com.nicco.home.data.datasource

import com.nicco.home.data.retrofit.HomeCardApi
import com.nicco.home.data.retrofit.HomeCardResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow

class RemoteHomeDataSourceImp(val homeApi: HomeCardApi): RemoteHomeDataSource {

    override suspend fun getListHome(): Flow<List<HomeCardResponse>>? {
        delay(2000)

        return homeApi.getHomeCard()
//        throw IllegalArgumentException("Deu brio")
//        CallRetrofit().sendPutMethod()
//        val list : Flow<List<HomeCardModel>>? = emptyList<HomeCardModel>()
        return null
    }
}