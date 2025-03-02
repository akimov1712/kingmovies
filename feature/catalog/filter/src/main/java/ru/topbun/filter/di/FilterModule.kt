package ru.topbun.filter.di

import cafe.adriel.voyager.core.registry.screenModule
import ru.topbun.filter.FilterDialog
import ru.topbun.navigation.SharedScreen

val filterScreenModule = screenModule {
    register<SharedScreen.FilterDialog> { FilterDialog }
}