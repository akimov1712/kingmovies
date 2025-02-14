package ru.topbun.privacy_policy

import ru.topbun.domain.entity.terms.TermsEntity

data class PrivacyState(
    val privacyList: List<TermsEntity> = emptyList()
)
