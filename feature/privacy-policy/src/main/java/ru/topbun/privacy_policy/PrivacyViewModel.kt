package ru.topbun.privacy_policy

import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.launch
import org.koin.core.KoinApplication.Companion.init
import ru.topbun.domain.useCase.privacy.LoadPrivacyUseCase
import ru.topbun.ui.ViewModelState

class PrivacyViewModel(
    private val navigator: Navigator,
    private val loadPrivacyUseCase: LoadPrivacyUseCase
): ViewModelState<PrivacyState>(PrivacyState()) {

    private fun loadPrivacy() = viewModelScope.launch {
        val privacy = loadPrivacyUseCase()
        updateState { copy(privacy) }
    }

    fun clickBack() = navigator.pop()

    init {
        loadPrivacy()
    }

}