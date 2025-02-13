package ru.topbun.splash

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.compose.getKoin
import org.koin.core.parameter.parametersOf
import ru.topbun.ui.components.PulseLoading
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.utills.koinInject
import ru.topbun.ui.utills.koinViewModel

object SplashScreen : Screen {

    @Composable
    override fun Content() {
        ScreenContent()
    }
}

@Composable
private fun ScreenContent() {
    val navigator = LocalNavigator.currentOrThrow
    val viewModel = koinViewModel<SplashViewModel>(navigator)
    val state by viewModel.collectAsState

    val size by animateSizeAsState(
        targetValue = if (!state.isLoading) Size(128f, 128f) else Size(0f, 0f),
        animationSpec = tween(state.speedAnimate)
    )
    val scale by animateFloatAsState(
        targetValue = if (!state.isLoading) 10f else 1f,
        animationSpec = tween(state.speedAnimate)
    )

    val animateColor1 by animateColorAsState(
        targetValue = if (!state.isLoading) Color.White else Colors.RED_100,
        animationSpec = tween(state.speedAnimate)
    )
    val animateColor2 by animateColorAsState(
        targetValue = if (!state.isLoading) Color.White else Colors.RED_200,
        animationSpec = tween(state.speedAnimate)
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
        AnimatedIcon(animateBrush)
        Loader(animateBrush, state.isLoading)
    }
}

@Composable
private fun Loader(animateBrush: Brush, isVisible: Boolean) {
    val animateVisible by animateFloatAsState(
        if (isVisible) 1f else 0f,
        tween(600)
    )
    Column(
        Modifier.alpha(animateVisible)
    ) {
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
private fun AnimatedIcon(animateBrush: Brush) {
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
                },
        )
    }
}
