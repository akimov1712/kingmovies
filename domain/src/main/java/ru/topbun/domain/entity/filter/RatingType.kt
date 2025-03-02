package ru.topbun.domain.entity.filter

enum class RatingType {

    FROM_6, FROM_7, FROM_8, FROM_9, FROM_10;

    override fun toString(): String {
        return when(this){
            FROM_6 -> "От 6.0"
            FROM_7 -> "От 7.0"
            FROM_8 -> "От 8.0"
            FROM_9 -> "От 9.0"
            FROM_10 -> "10"
        }
    }

    fun toInt(): Int {
        return when(this){
            FROM_6 -> 6
            FROM_7 -> 7
            FROM_8 -> 8
            FROM_9 -> 9
            FROM_10 -> 10
        }
    }

}