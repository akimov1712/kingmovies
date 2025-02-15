package ru.topbun.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.topbun.ui.R
import ru.topbun.ui.components.AppText
import ru.topbun.ui.components.Cards
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo

@Composable
fun FilmActors() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ActorList()
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            repeat(10) {
                item {
                    Cards.VERTICAL.Card()
                }
            }
        }
    }
}

@Composable
private fun ActorList() {
    val state = rememberLazyListState()
    LazyRow(
        state = state,
        flingBehavior = rememberSnapFlingBehavior(lazyListState = state, SnapPosition.Start),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        repeat(10) {
            item {
                ActorItem(it)
            }
        }
    }
}

@Composable
private fun ActorItem(it: Int) {
    Row(
        modifier = Modifier
            .background(
                color = if (it == 0) Colors.BG_300 else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(8.dp, 6.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(8.dp)),
            painter = painterResource(R.drawable.actor),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        AppText(
            text = "Джим Керри",
            style = Typo.XS,
            color = Colors.TEXT_100
        )
    }
}
