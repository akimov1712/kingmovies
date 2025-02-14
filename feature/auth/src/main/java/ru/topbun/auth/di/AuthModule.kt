package ru.topbun.auth.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.dsl.module
import ru.topbun.auth.AuthDialog
import ru.topbun.navigation.SharedScreen

val authScreenModule = screenModule {
    register<SharedScreen.AuthDialog> { AuthDialog }
}