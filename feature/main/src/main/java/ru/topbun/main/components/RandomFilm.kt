package ru.topbun.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.topbun.ui.components.AppText
import ru.topbun.ui.components.Buttons
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo

@Composable
fun RandomFilm() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ){
        RandomPreview()
        Spacer(Modifier.height(12.dp))
        Buttons.RED.Button(
            text = "Смотреть",
            modifier = Modifier.fillMaxWidth().height(48.dp)
        ) { }
        Spacer(Modifier.height(8.dp))
        Buttons.TRANSPARENT.Button(
            text = "Следующий фильм",
            modifier = Modifier.fillMaxWidth().height(48.dp)
        ) { }
    }
}

@Composable
private fun RandomPreview() {
    Box{
        RandomImage()
        RandomInfo(
            modifier = Modifier.align(Alignment.BottomStart)
                .padding(12.dp)
        )
    }
}

@Composable
private fun RandomInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ){
        Tips()
        Spacer(Modifier.height(4.dp))
        AppText(
            text = "Барби",
            style = Typo.L,
            color = Colors.TEXT_100,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(Modifier.height(4.dp))
        AppText(
            text = "2023",
            style = Typo.S,
            color = Colors.TEXT_100.copy(0.8f),
        )
        Spacer(Modifier.height(8.dp))
        AppText(
            text = "Самая обыкновенная стереотипная Барби живёт в великолепном розовом Барбиленде, и каждый её день идеален.",
            style = Typo.S,
            color = Colors.TEXT_100.copy(0.8f),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun Tips() {
    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        ru.topbun.ui.components.Tips.RATING.Big(8.4f)
        ru.topbun.ui.components.Tips.QUALITY.Big("HD")
    }
}

@Composable
private fun RandomImage() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.65f)
            .clip(RoundedCornerShape(12.dp))
            .drawWithContent {
                drawContent()
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(0f),
                            Color.Black.copy(0.8f),
                        ),
                    ),
                )
            },
        painter = painterResource(ru.topbun.ui.R.drawable.random),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}