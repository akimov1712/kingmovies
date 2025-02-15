package ru.topbun.agreement.di

import cafe.adriel.voyager.core.registry.screenModule
import cafe.adriel.voyager.navigator.Navigator
import org.koin.dsl.module
import ru.topbun.agreement.AgreementScreen
import ru.topbun.agreement.AgreementViewModel
import ru.topbun.navigation.SharedScreen

val agreementModule = module {
    single { (nav: Navigator) ->
        AgreementViewModel(nav, get())
    }
}

val agreementScreenModule = screenModule {
    register<SharedScreen.AgreementScreen> {
        AgreementScreen
    }
}