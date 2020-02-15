package com.nicco.home.di.module

import com.nicco.home.data.retrofit.HomeCardApi
import org.koin.dsl.module
import retrofit2.Retrofit

val homeApiModule = module {
    single { homeApi(get()) }
}

fun homeApi(retrofit: Retrofit): HomeCardApi = retrofit.create(
    HomeCardApi::class.java)