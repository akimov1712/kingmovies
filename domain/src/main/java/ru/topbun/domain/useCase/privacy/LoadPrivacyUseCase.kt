package ru.topbun.domain.useCase.privacy

import ru.topbun.domain.repository.privacy.PrivacyRepository

class LoadPrivacyUseCase(private val repository: PrivacyRepository) {

    suspend operator fun invoke() = repository.loadPrivacy()

}