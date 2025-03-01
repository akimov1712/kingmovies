package ru.topbun.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import ru.topbun.catalog.components.GenreList
import ru.topbun.catalog.components.Title
import ru.topbun.ui.theme.Colors


object CatalogScreen: Screen {

    @Composable
    override fun Content() {
        ContentScreen()
    }
    
}

@Preview
@Composable
private fun ContentScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.BG_100)
            .systemBarsPadding(),
    ) {
        Title()
        Spacer(Modifier.height(20.dp))
        GenreList()
    }
}

