package ru.topbun.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import ru.topbun.search.components.TextField
import ru.topbun.search.components.Title
import ru.topbun.ui.components.AppText
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo

object SearchScreen: Screen {

    @Composable
    override fun Content() {
        ScreenContent()
    }

}

@Preview
@Composable
private fun ScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.BG_100)
            .systemBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        var search by remember { mutableStateOf("Уоллес и Громи Уоллес и Громит: Самая дикая месть... т") }
        Title()
        TextField(search){ search = it }
        AppText(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = buildAnnotatedString {
                if(search.isBlank()){
                    append("Популярное сейчас")
                } else {
                    append("Результаты поиска: ")
                    withStyle(SpanStyle(color = Colors.RED_100)){
                        append(search)
                    }
                }
            },
            style = Typo.M,
            color = Colors.TEXT_100
        )
    }
}

