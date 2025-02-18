package ru.topbun.film.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.topbun.ui.R
import ru.topbun.ui.components.AppText
import ru.topbun.ui.components.TitleWithContent
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo

@Composable
internal fun ActorList() {
    val state = rememberLazyListState()
    TitleWithContent("Актёрский состав") {
        LazyRow(
            state = state,
            flingBehavior = rememberSnapFlingBehavior(lazyListState = state, SnapPosition.Start),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ){
            repeat(10){
                item {
                    ActorItem()
                }
            }
        }
    }
}

@Composable
private fun ActorItem() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.keanu),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column {
            AppText(
                text = "Киану Ривз",
                style = Typo.M,
                color = Colors.TEXT_100
            )
            Spacer(Modifier.height(2.dp))
            AppText(
                text = "Keanu Reeves",
                style = Typo.XS,
                color = Colors.RED_100
            )
        }
    }
}