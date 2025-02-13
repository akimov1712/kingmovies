package ru.topbun.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

open class ViewModelState<T>(initialState: T): ViewModel() {

    private val _state = MutableStateFlow<T>(initialState)
    val state: StateFlow<T> = _state.asStateFlow()

    val collectAsState: State<T> @Composable get() = state.collectAsState()

    open fun updateState(update: T.() -> T) {
        _state.value = state.value.update()
    }

}