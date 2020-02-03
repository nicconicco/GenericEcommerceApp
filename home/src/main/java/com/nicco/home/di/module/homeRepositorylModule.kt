package com.nicco.home.di.module

import com.nicco.home.data.repository.HomeRepository
import com.nicco.home.data.repository.HomeRepositoryImp
import org.koin.dsl.module

val homeRepositorylModule = module {
    factory <HomeRepository> { HomeRepositoryImp(get()) }
}