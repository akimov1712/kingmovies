package ru.topbun.domain.entity.movie

import ru.topbun.domain.entity.country.CountryEntity

data class ImageMovieEntity(
    val id: Int,
    val isExternal: Boolean,
    val type: ImageMovieType,
    val path: String,
    val country: CountryEntity
)
