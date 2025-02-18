package ru.topbun.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo

@Composable
fun TitleWithContent(
    title: String = "",
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AppText(
            modifier = Modifier.padding(start = 16.dp),
            text = title,
            style = Typo.L,
            color = Colors.TEXT_100
        )
        content()

    }
}