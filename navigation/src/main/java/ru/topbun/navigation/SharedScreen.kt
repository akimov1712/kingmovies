package ru.topbun.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen: ScreenProvider {

    data object PrivacyScreen : SharedScreen()
    data object AgreementScreen : SharedScreen()
    data object AuthDialog : SharedScreen()

}