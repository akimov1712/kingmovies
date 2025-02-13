package ru.topbun.privacy_policy.di

import cafe.adriel.voyager.navigator.Navigator
import org.koin.dsl.module
import ru.topbun.privacy_policy.PrivacyViewModel

val privacyModule = module {
    single { (nav: Navigator) ->
        PrivacyViewModel(nav, get())
    }
}