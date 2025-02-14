package ru.topbun.domain.useCase.terms

import ru.topbun.domain.repository.terms.TermsRepository

class LoadPrivacyUseCase(private val repository: TermsRepository) {

    suspend operator fun invoke() = repository.loadPrivacy()

}