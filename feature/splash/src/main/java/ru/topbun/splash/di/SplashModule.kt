package ru.topbun.splash.di

import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.topbun.splash.SplashScreen
import ru.topbun.splash.SplashViewModel

val splashModule = module {
    single{ (navigator: Navigator) ->
        SplashViewModel(navigator)
    }
}