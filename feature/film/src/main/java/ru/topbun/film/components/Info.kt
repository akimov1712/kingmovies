package ru.topbun.film.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.topbun.ui.components.AppText
import ru.topbun.ui.components.Tips
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo

@Composable
internal fun Info() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Tags()
        NameWithQuote()
    }
}

@Composable
private fun NameWithQuote() {
    AppText(
        text = "Фильм Уоллес и Громит: Самая дикая месть смотреть онлайн",
        style = Typo.L,
        color = Colors.TEXT_100,
    )
    AppText(
        text = "«Не трогай правоохранительные органы, они могут возбудить» — Стетхем Д.",
        style = Typo.S,
        color = Colors.TEXT_200,
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Tags() {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Tips.RATING.Big(8.4f)
        Tips.QUALITY.Big("HD")
        AppText("2025", style = Typo.S, color = Colors.TEXT_200, modifier = Modifier.align(Alignment.CenterVertically))
        AppText("Великобритания", style = Typo.S, color = Colors.TEXT_200, modifier = Modifier.align(
            Alignment.CenterVertically))
        AppText("Мультфильмы", style = Typo.S, color = Colors.TEXT_200, modifier = Modifier.align(
            Alignment.CenterVertically))
    }
}
