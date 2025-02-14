package ru.topbun.agreement

import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.launch
import ru.topbun.domain.useCase.terms.LoadAgreementUseCase
import ru.topbun.ui.ViewModelState

class AgreementViewModel(
    private val navigator: Navigator,
    private val loadAgreementUseCase: LoadAgreementUseCase
): ViewModelState<AgreementState>(AgreementState()) {

    private fun loadAgreement() = viewModelScope.launch {
        val agreement = loadAgreementUseCase()
        updateState { copy(agreement) }
    }

    fun clickBack() = navigator.pop()

    init {
        loadAgreement()
    }

}