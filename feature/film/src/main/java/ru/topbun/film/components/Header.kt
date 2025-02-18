package ru.topbun.film.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.topbun.ui.R
import ru.topbun.ui.theme.Colors

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.15f)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .drawWithContent {
                    drawContent()
                    drawRect(
                        Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color.Transparent,
                                Color.Transparent,
                                Color.Transparent,
                                Color.Transparent,
                                Colors.BG_100.copy(0.25f),
                                Colors.BG_100
                            )
                        )
                    )
                    drawRect(
                        Brush.verticalGradient(
                            listOf(
                                Colors.BG_100,
                                Color.Transparent,
                                Color.Transparent,
                                Color.Transparent,
                            )
                        )
                    )
                },
            painter = painterResource(R.drawable.banner),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Image(
            modifier = Modifier
                .widthIn(max = 250.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            painter = painterResource(R.drawable.banner_logo),
            contentDescription = null,
        )
    }
}