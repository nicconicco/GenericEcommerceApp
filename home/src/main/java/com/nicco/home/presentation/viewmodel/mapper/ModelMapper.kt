package com.nicco.home.presentation.viewmodel.mapper

import com.nicco.home.data.retrofit.HomeCardResponse
import com.nicco.home.presentation.model.HomeCardModel

object ModelMapper {
    fun map(response: List<HomeCardResponse>): List<HomeCardModel> {
        var list = listOf<HomeCardModel>()
        val result = response

        result?.let {
            list = result.map { homeCardResponse ->
                HomeCardModel(
                    id = homeCardResponse.id,
                    description = homeCardResponse.description,
                    price = homeCardResponse.price,
                    imgProduct = homeCardResponse.imgProduct
                )
            }
        }

        return list
    }
}