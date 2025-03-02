package ru.topbun.filter

internal enum class FilterItems(
    val title: String,
    val iconRes: Int,
    val requestParam: Boolean = false
) {

    SORTED(
        title = "Сортировать по",
        iconRes = ru.topbun.ui.R.drawable.ic_filter_outlined,
        requestParam = true
    ),

    YEAR(
        title = "Год выпуска",
        iconRes = ru.topbun.ui.R.drawable.ic_filter_calendar,
    ),

    RATING(
        title = "Рейтинг",
        iconRes = ru.topbun.ui.R.drawable.ic_filter_rating,
    ),

}