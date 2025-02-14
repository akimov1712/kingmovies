package ru.topbun.privacy_policy.di

import cafe.adriel.voyager.core.registry.screenModule
import cafe.adriel.voyager.navigator.Navigator
import org.koin.dsl.module
import ru.topbun.navigation.SharedScreen
import ru.topbun.privacy_policy.PrivacyScreen
import ru.topbun.privacy_policy.PrivacyViewModel

val privacyModule = module {
    single { (nav: Navigator) ->
        PrivacyViewModel(nav, get())
    }
}

val privacyScreenModule = screenModule {
    register<SharedScreen.PrivacyScreen> {
        PrivacyScreen
    }
}