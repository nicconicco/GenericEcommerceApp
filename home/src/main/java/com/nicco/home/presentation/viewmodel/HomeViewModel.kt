package com.nicco.home.presentation.viewmodel

import androidx.lifecycle.*
import com.nicco.home.data.repository.HomeRepository
import com.nicco.home.presentation.model.HomeCardModel
import com.nicco.home.presentation.viewmodel.HomeViewAction.HomeLoading
import com.nicco.home.presentation.viewmodel.mapper.ModelMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

sealed class HomeViewAction {
    open class HomeSuccess(val itens: List<HomeCardModel>?) : HomeViewAction()
    open class HomeError(val msg: String) : HomeViewAction()
    open class HomeLoading(val loading: Boolean) : HomeViewAction()
}

@ExperimentalCoroutinesApi
@FlowPreview
class HomeViewModel(private val repository: HomeRepository) : ViewModel() {

    private val _actionView = MediatorLiveData<HomeViewAction>()
    val actionView: LiveData<HomeViewAction>
        get() = _actionView

    private val homeChannel = ConflatedBroadcastChannel<HomeCardModel?>()

    init {
        offerToChannel(HomeCardModel())
        homeChannel
            .asFlow()
            .mapLatest {
                _actionView.value = HomeLoading(true)
                val items = repository.getListHome()
                items?.let { itens ->
                    itens.let { response ->
                        _actionView.value = HomeViewAction.HomeSuccess(ModelMapper.map(response))
                        _actionView.value = HomeLoading(false)
                    }
                } ?: run {
                    _actionView.value = HomeLoading(false)
                    _actionView.value = HomeViewAction.HomeError("Lista vazia")
                }
            }
            .onCompletion {
                _actionView.value = HomeLoading(false)
            }
            .catch { throwable ->
                _actionView.value = HomeLoading(false)
                _actionView.value = HomeViewAction.HomeError(throwable.message ?: "")
            }
            .launchIn(viewModelScope)
    }

    private fun offerToChannel(homeCardModel: HomeCardModel) {
        if (!homeChannel.isClosedForSend) {
            homeChannel.offer(homeCardModel)
        }
    }
}

