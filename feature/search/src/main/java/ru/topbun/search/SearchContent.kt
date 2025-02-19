package ru.topbun.search

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import ru.topbun.search.components.Subtitle
import ru.topbun.search.components.TextField
import ru.topbun.search.components.Title
import ru.topbun.ui.components.Cards
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.utills.isRowVisible

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
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        val state = rememberLazyGridState()
        var search by remember { mutableStateOf("") }

        val columns = 170.dp
        val isShowTitle by state.isRowVisible(columns, 3)
        Column{
            val sizeSpacer = if(isShowTitle) 20.dp else 0.dp
            Title(isShowTitle)
            Spacer(Modifier.animateContentSize().height(sizeSpacer))
            TextField(search){ search = it }
            Spacer(Modifier.animateContentSize().height(sizeSpacer))
            Subtitle(search, isShowTitle)
        }
        LazyVerticalGrid(
            state = state,
            columns = GridCells.Adaptive(170.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            repeat(100){
                item {
                    Cards.VERTICAL.Card()
                }
            }
        }
    }
}


