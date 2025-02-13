package ru.topbun.domain.repository.privacy

import ru.topbun.domain.entity.privacy.PrivacyEntity

interface PrivacyRepository {

    suspend fun loadPrivacy(): List<PrivacyEntity>

}