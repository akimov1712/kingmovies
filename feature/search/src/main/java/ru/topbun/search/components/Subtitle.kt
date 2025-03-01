package ru.topbun.search.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import ru.topbun.ui.components.AppText
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo

@Composable
internal fun Subtitle(search: String, isVisible: Boolean) {
    val size = if(isVisible) Modifier.wrapContentHeight() else Modifier.height(0.dp)
    AppText(
        modifier = Modifier.padding(horizontal = 16.dp)
            .animateContentSize()
            .then(size),
        text = buildAnnotatedString {
            if (search.isBlank()) {
                append("Популярное сейчас")
            } else {
                append("Результаты поиска: ")
                withStyle(SpanStyle(color = Colors.RED_100)) {
                    append(search)
                }
            }
        },
        style = Typo.M,
        color = Colors.TEXT_100,
        fontWeight = FontWeight.SemiBold
    )
}