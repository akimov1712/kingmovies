package ru.topbun.film.components

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ru.topbun.ui.components.Cards
import ru.topbun.ui.components.TitleWithContent

@Composable
internal fun ResemblingList() {
    val state = rememberLazyListState()
    TitleWithContent("Похожие") {
        LazyRow(
            state = state,
            flingBehavior = rememberSnapFlingBehavior(lazyListState = state, SnapPosition.Start),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ){
            repeat(10){
                item {
                    Cards.VERTICAL.Card()
                }
            }
        }
    }
}