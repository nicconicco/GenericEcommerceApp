package com.nicco.core.di

import com.nicco.core.BuildConfig
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

//fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient { future put interceptor log
fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}
