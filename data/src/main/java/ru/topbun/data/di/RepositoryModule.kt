package ru.topbun.data.di

import org.koin.dsl.module
import ru.topbun.data.repository.PrivacyRepositoryImpl
import ru.topbun.domain.repository.privacy.PrivacyRepository

val repositoryModule = module {
    single<PrivacyRepository> { PrivacyRepositoryImpl(get()) }
}