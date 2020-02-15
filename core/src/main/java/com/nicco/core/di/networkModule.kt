package com.nicco.core.di

import com.nicco.core.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideLogInterceptor() }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()
}

fun provideLogInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()

    if (BuildConfig.DEBUG)
        logging.level = HttpLoggingInterceptor.Level.BODY
    return logging
}
