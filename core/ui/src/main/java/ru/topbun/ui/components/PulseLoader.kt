package ru.topbun.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun PulseLoading(
    durationMillis: Int = 1500,
    maxPulseSize: Float = 100f,
    minPulseSize: Float = 10f,
    pulseColor: Brush
) {
    var runSecondPulse by remember { mutableStateOf(false) }

    Box(Modifier.size(maxPulseSize.dp), contentAlignment = Alignment.Center) {
        PulseItem(minPulseSize, maxPulseSize, durationMillis, pulseColor)
        if (runSecondPulse) PulseItem(minPulseSize, maxPulseSize, durationMillis, pulseColor)
    }

    LaunchedEffect(Unit) {
        delay(durationMillis / 2L)
        runSecondPulse = true
    }
}

@Composable
private fun PulseItem(
    minPulseSize: Float,
    maxPulseSize: Float,
    durationMillis: Int,
    pulseColor: Brush
) {
    val infiniteTransition = rememberInfiniteTransition()

    val size by infiniteTransition.animateFloat(
        initialValue = minPulseSize,
        targetValue = maxPulseSize,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val alpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box(
        Modifier
            .size(size.dp)
            .alpha(alpha)
            .background(pulseColor, CircleShape)
    ) {}
}
