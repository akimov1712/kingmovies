package ru.topbun.data.di

import org.koin.dsl.module
import ru.topbun.data.repository.TermsRepositoryImpl
import ru.topbun.domain.repository.terms.TermsRepository

val repositoryModule = module {
    single<TermsRepository> { TermsRepositoryImpl(get()) }
}