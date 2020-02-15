package com.nicco.home.di.module

import com.nicco.home.data.repository.HomeRepository
import com.nicco.home.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@FlowPreview
@ExperimentalCoroutinesApi
val homeViewModelModule = module {
    viewModel { HomeViewModel(repository = get() as HomeRepository) }
}