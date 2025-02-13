package ru.topbun.ui.utills

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parameterSetOf
import org.koin.core.parameter.parametersOf

@Composable
inline fun <reified T: ViewModel> koinViewModel(vararg params: Any?) = koinViewModel<T>{ parametersOf(*params) }

@Composable
inline fun <reified T> koinInject(vararg params: Any?) = koinInject<T>{ parametersOf(*params) }