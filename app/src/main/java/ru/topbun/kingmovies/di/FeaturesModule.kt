package ru.topbun.kingmovies.di

import org.koin.dsl.module
import ru.topbun.privacy_policy.di.privacyModule
import ru.topbun.splash.di.splashModule

val featuresModule = module {
    includes(splashModule, privacyModule)
}