package ru.topbun.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.topbun.ui.components.AppText
import ru.topbun.ui.components.Tips
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo
import ru.topbun.ui.utills.getScreenSize

@Composable
fun Banner() {
    Column{
        BannerImage()
        BannerSlider()
    }
}

@Composable
private fun BannerSlider() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        repeat(10) {
            item { BannerSliderItem() }
        }
    }
}

@Composable
private fun BannerSliderItem() {
    Box(
        modifier = Modifier
            .height(90.dp)
            .aspectRatio(1.7f)
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(ru.topbun.ui.R.drawable.banner),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .align(Alignment.BottomCenter),
            trackColor = Color.Transparent,
            color = Colors.RED_200,
            progress = { 0.5f }
        )
    }
}

@Composable
private fun BannerImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.5f)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .drawWithContent {
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Colors.BG_100.copy(0f),
                                Colors.BG_100.copy(0f),
                                Colors.BG_100.copy(0.55f),
                                Colors.BG_100
                            ),
                        ),
                        size = size
                    )
                },
            painter = painterResource(ru.topbun.ui.R.drawable.banner),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 16.dp, bottom = 20.dp)
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                modifier = Modifier.widthIn(max = getScreenSize().width / 2),
                painter = painterResource(ru.topbun.ui.R.drawable.banner_logo),
                contentDescription = null,
            )
            Column {
                Tips.RATING.Small(6.7f)
                Spacer(Modifier.height(3.dp))
                Tips.QUALITY.Small("HD")
                Spacer(Modifier
                    .weight(1f)
                    .heightIn(min = 3.dp))
                AppText(
                    text = "2024",
                    style = Typo.XXS,
                    color = Colors.TEXT_200
                )
            }
        }
    }
}