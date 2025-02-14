package ru.topbun.kingmovies.di

import org.koin.dsl.module
import ru.topbun.domain.useCase.terms.LoadPrivacyUseCase

val useCaseModule = module {
    single { LoadPrivacyUseCase(get()) }
}