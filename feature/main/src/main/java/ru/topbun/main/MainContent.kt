package ru.topbun.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import ru.topbun.main.components.Banner
import ru.topbun.main.components.FilmActors
import ru.topbun.ui.components.TitleWithContent
import ru.topbun.ui.theme.Colors

object MainScreen: Screen {

    @Composable
    override fun Content() {
        ScreenContent()
    }

}

@Preview
@Composable
private fun ScreenContent(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.BG_100),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Banner()
        TitleWithContent("Кино с участием") {
            FilmActors()
        }
    }
}
