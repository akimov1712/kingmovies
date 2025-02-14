package ru.topbun.agreement

import ru.topbun.domain.entity.terms.TermsEntity

data class AgreementState(
    val agreementList: List<TermsEntity> = emptyList()
)
