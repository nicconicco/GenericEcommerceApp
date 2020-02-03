package com.nicco.home.presentation.viewmodel

import androidx.lifecycle.*
import com.nicco.home.data.repository.HomeRepositoryImp
import com.nicco.home.presentation.model.HomeCardModel
import com.nicco.home.presentation.viewmodel.HomeViewState.HomeLoading
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

sealed class HomeViewState {
    open class HomeSuccess(val itens: List<HomeCardModel>?) : HomeViewState()
    open class HomeError(val msg: String) : HomeViewState()
    open class HomeLoading(val loading: Boolean) : HomeViewState()
}

@ExperimentalCoroutinesApi
@FlowPreview
class HomeViewModel(private val repository: HomeRepositoryImp) : ViewModel() {

    private val _homeState = MutableLiveData<HomeViewState>()
    val homeState: LiveData<HomeViewState>
        get() = _homeState

    private val homeChannel = ConflatedBroadcastChannel<HomeCardModel?>()

    init {
        offerToChannel(HomeCardModel())

        homeChannel
            .asFlow()
            .mapLatest {
                _homeState.value = HomeLoading(true)
                val items = repository.getListHome()
                items?.let { itens ->
                    itens.asLiveData().let {
                        _homeState.value = HomeViewState.HomeSuccess(it.value)
                    }
                } ?: run {
                    _homeState.value = HomeViewState.HomeError("Lista vazia")
                    _homeState.value = HomeLoading(false)
                }
            }
            .onCompletion {
                _homeState.value = HomeLoading(false)
            }
            .catch { throwable ->
                _homeState.value = HomeLoading(false)
                _homeState.value = HomeViewState.HomeError(throwable.message ?: "")
            }
            .launchIn(viewModelScope)
    }

    private fun offerToChannel(homeCardModel: HomeCardModel) {
        if (!homeChannel.isClosedForSend) {
            homeChannel.offer(homeCardModel)
        }
    }
}

