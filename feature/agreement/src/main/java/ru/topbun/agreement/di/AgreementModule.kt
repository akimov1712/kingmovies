package ru.topbun.agreement.di

import cafe.adriel.voyager.navigator.Navigator
import org.koin.dsl.module
import ru.topbun.agreement.AgreementViewModel

val agreementModule = module {
    single { (nav: Navigator) ->
        AgreementViewModel(nav, get())
    }
}