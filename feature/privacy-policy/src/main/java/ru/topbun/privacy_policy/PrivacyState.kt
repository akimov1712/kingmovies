package ru.topbun.privacy_policy

import ru.topbun.domain.entity.privacy.PrivacyEntity

data class PrivacyState(
    val privacyList: List<PrivacyEntity> = emptyList()
)
