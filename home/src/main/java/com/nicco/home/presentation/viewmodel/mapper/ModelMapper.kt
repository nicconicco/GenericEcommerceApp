package com.nicco.home.presentation.viewmodel.mapper

import androidx.lifecycle.LiveData
import com.nicco.home.data.retrofit.HomeCardResponse
import com.nicco.home.presentation.model.HomeCardModel

object ModelMapper {
    fun map(response: LiveData<List<HomeCardResponse>>): List<HomeCardModel> {
        var list = listOf<HomeCardModel>()
        val result = response.value

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