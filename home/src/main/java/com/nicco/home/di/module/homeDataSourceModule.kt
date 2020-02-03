package com.nicco.home.di.module

import com.nicco.home.data.datasource.RemoteHomeDataSource
import com.nicco.home.data.datasource.RemoteHomeDataSourceImp
import org.koin.dsl.module

val homeDataSourcelModule = module {
    factory<RemoteHomeDataSource> { get() }
}