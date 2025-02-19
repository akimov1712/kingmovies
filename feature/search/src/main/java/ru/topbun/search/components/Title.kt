package ru.topbun.search.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.topbun.ui.components.AppText
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo

@Composable
internal fun Title(isVisible: Boolean) {
    val size = if(isVisible) Modifier.wrapContentHeight() else Modifier.height(0.dp)
    AppText(
        modifier = Modifier
            .padding(start = 30.dp, top = 20.dp)
            .animateContentSize()
            .then(size),
        text = "Поиск",
        style = Typo.L,
        color = Colors.TEXT_100
    )
}