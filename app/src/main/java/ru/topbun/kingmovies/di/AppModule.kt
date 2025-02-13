package ru.topbun.kingmovies.di

import cafe.adriel.voyager.navigator.Navigator
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue
import org.koin.dsl.module
import ru.topbun.data.di.repositoryModule

val appModule = module {
    includes(featuresModule, useCaseModule, repositoryModule)
}