package ru.topbun.splash

import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.topbun.ui.ViewModelState

class SplashViewModel(
    private val navigator: Navigator
): ViewModelState<SplashState>(SplashState()) {

    private fun load() = viewModelScope.launch {
        delay(3000)
        updateState { copy(false) }
        delay(2000)
        navigator.push(TODO())
    }

    init {
        load()
    }

}