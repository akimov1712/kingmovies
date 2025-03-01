package ru.topbun.catalog.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import ru.topbun.ui.components.AppText
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo

@Composable
internal fun ColumnScope.GenreList() {
    LazyRow(
        modifier = Modifier.fillMaxWidth().weight(1f),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val genres = listOf("Все жанры", "Боевики", "Фантастика", "Комедии", "Мультфильмы", "Вестерн")
        itemsIndexed(genres){ index, item ->
            GenreItem(item, index == 1)
        }
    }
}

@Composable
private fun GenreItem(genre: String, isSelected: Boolean) {
    val textColor = if (isSelected) Colors.TEXT_100 else Colors.TEXT_200
    val bgColor = if (isSelected) Colors.RED_100_200 else SolidColor(Colors.BG_200)
    AppText(
        modifier = Modifier.background(bgColor, RoundedCornerShape(12.dp)).padding(vertical = 12.dp, horizontal = 20.dp),
        text = genre,
        color = textColor,
        style = Typo.M
    )
}