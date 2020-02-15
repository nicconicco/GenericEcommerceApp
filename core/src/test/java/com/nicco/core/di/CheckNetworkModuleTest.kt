package com.nicco.core.di

import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

class CheckHomeModulesTest : KoinTest {

    @Test
    fun checkAllModules() {
        startKoin {
            listOf(
                networkModule
            )
        }.checkModules()
    }
}