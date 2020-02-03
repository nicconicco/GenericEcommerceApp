package com.nicco.home.data.datasource

import com.nicco.home.presentation.model.HomeCardModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow

class RemoteHomeDataSourceImp: RemoteHomeDataSource {

    override suspend fun getListHome(): Flow<List<HomeCardModel>>? {
        delay(2000)
//        throw IllegalArgumentException("Deu brio")
//        CallRetrofit().sendPutMethod()
//        val list : Flow<List<HomeCardModel>>? = emptyList<HomeCardModel>()
        return null
    }
}