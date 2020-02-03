package com.nicco.home

import com.nicco.home.di.module.homeDataSourcelModule
import com.nicco.home.di.module.homeRepositorylModule
import com.nicco.home.di.module.homeViewModelModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

@ExperimentalCoroutinesApi
class CheckHomeModulesTest : KoinTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @FlowPreview
    @Test
    fun checkAllModules() = runBlockingTest {
        startKoin {
            listOf(
                homeViewModelModule,
                homeRepositorylModule,
                homeDataSourcelModule
            )
        }.checkModules()
    }
}
