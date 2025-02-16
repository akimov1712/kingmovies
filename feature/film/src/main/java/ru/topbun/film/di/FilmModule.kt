package ru.topbun.film.di

import org.koin.dsl.module
import ru.topbun.film.FilmViewModel

val filmScreenModule = module {
    single { FilmViewModel() }
}