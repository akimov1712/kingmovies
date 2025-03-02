package ru.topbun.domain.entity.filter

enum class SortType {

    NEW, DATE, RATING;

    override fun toString(): String {
        return when(this){
            NEW -> "Новое в приложении"
            DATE -> "По дате выпуска"
            RATING -> "По рейтингу"
        }
    }

}