package ru.topbun.splash

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.delay
import ru.topbun.ui.components.PulseLoading
import ru.topbun.ui.theme.Colors

object SplashScreen : Screen {

    @Composable
    override fun Content() {
        ScreenContent()
    }
}

@Preview(showBackground = true)
@Composable
private fun ScreenContent() {
    var isResize by remember { mutableStateOf(false) }
    val speedAnimate = 600

    val size by animateSizeAsState(
        targetValue = if (isResize) Size(128f, 128f) else Size(0f, 0f),
        animationSpec = tween(speedAnimate)
    )
    val scale by animateFloatAsState(
        targetValue = if (isResize) 10f else 1f,
        animationSpec = tween(speedAnimate)
    )

    val animateColor1 by animateColorAsState(
        targetValue = if (isResize) Color.White else Colors.RED_100,
        animationSpec = tween(speedAnimate)
    )
    val animateColor2 by animateColorAsState(
        targetValue = if (isResize) Color.White else Colors.RED_200,
        animationSpec = tween(speedAnimate)
    )
    val animateBrush = Brush.horizontalGradient(listOf(animateColor1, animateColor2))

    Box(
        Modifier
            .fillMaxSize()
            .background(Colors.BG_100)
            .statusBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedCircle(size, scale)
        AnimatedIcon(animateBrush) { isResize = !isResize }
        Loader(animateBrush)
    }
}

@Composable
private fun Loader(animateBrush: Brush) {
    Column {
        Spacer(Modifier.fillMaxHeight(0.5f))
        PulseLoading(pulseColor = animateBrush)
    }
}

@Composable
private fun AnimatedCircle(size: Size, scale: Float) {
    Box(
        Modifier
            .size(size.width.dp, size.height.dp)
            .scale(scale)
            .background(Colors.RED_100_200, CircleShape)
    )
}

@Composable
private fun AnimatedIcon(animateBrush: Brush, onClick: () -> Unit) {
    Box(contentAlignment = Alignment.Center) {
        Icon(
            painter = painterResource(ru.topbun.ui.R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .graphicsLayer(alpha = 0.99f)
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(brush = animateBrush, blendMode = BlendMode.SrcAtop)
                    }
                }
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) { onClick() },
        )
    }
}
