package ru.topbun.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.topbun.ui.components.AppText
import ru.topbun.ui.components.Cards
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo

@Composable
fun FilmList() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AppText(
            modifier = Modifier.padding(start = 16.dp),
            text = "Вы смотрели",
            style = Typo.L,
            color = Colors.TEXT_100
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            repeat(10) {
                item {
                    Cards.HORIZONTAL.Card()
                }
            }
        }
    }
}
