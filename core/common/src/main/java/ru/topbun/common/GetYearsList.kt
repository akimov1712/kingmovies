package ru.topbun.common

import java.util.Calendar

fun getYearsList(): List<Int> {
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    return (currentYear downTo 1960).toList()
}