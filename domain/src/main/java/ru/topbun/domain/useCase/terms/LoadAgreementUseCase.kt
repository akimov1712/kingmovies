package ru.topbun.domain.useCase.terms

import ru.topbun.domain.repository.terms.TermsRepository

class LoadAgreementUseCase(private val repository: TermsRepository) {

    suspend operator fun invoke() = repository.loadAgreement()

}