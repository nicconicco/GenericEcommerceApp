package com.nicco.home.presentation.viewmodel

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<V, A> : ViewModel() {
    abstract val viewState: V
    abstract fun viewAction(action: A)
}