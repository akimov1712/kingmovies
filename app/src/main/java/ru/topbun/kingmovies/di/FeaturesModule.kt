package ru.topbun.kingmovies.di

import org.koin.dsl.module
import ru.topbun.agreement.di.agreementModule
import ru.topbun.film.di.filmScreenModule
import ru.topbun.privacy_policy.di.privacyModule
import ru.topbun.splash.di.splashModule

val featuresModule = module {
    includes(splashModule, privacyModule, agreementModule, filmScreenModule)
}