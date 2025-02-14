package ru.topbun.domain.repository.terms

import ru.topbun.domain.entity.terms.TermsEntity

interface TermsRepository {

    suspend fun loadPrivacy(): List<TermsEntity>
    suspend fun loadAgreement(): List<TermsEntity>

}