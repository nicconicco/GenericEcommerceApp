package com.nicco.genericecommerceapp

import android.app.Application
import com.nicco.home.di.module.homeDataSourcelModule
import com.nicco.home.di.module.homeRepositorylModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger

open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            if (BuildConfig.DEBUG) androidLogger() else EmptyLogger()
            androidContext(applicationContext)
        }
    }
}
