package ru.topbun.domain.entity.movie

enum class MovieQuality {

    TS, HD, _4K;

    override fun toString(): String {
        return when(this){
            _4K -> "4K"
            TS -> "TS"
            HD -> "HD"
        }
    }}