package ru.topbun.catalog.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.topbun.ui.components.AppText
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo

@Composable
internal fun Title() {
    AppText(
        modifier = Modifier
            .padding(start = 30.dp, top = 20.dp),
        text = "Каталог жанров",
        style = Typo.L,
        color = Colors.TEXT_100
    )
}