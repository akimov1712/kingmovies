package ru.topbun.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.utills.rippleClickable

@Composable
fun AppIconButton(painter: Int, tint: Color = Colors.WHITE, size: Dp = 36.dp, onClick: () -> Unit) {
    Icon(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .background(Colors.WHITE.copy(0.1f))
            .rippleClickable{ onClick() }
            .padding(10.dp),
        painter = painterResource(painter),
        contentDescription = null,
        tint = tint
    )
}