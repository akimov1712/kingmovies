package ru.topbun.film

import ru.topbun.ui.ViewModelState

class FilmViewModel: ViewModelState<FilmState>(FilmState()) {

    fun switchOpenDescr() = updateState { copy(openDescription = !openDescription) }

}