package ru.topbun.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.topbun.ui.theme.Colors


@Composable
fun BottomSheetWrapper(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(24.dp, 24.dp),
    containerColor: Color = Colors.BG_200,
    tonalElevation: Dp = 4.dp,
    dragHandle: @Composable (() -> Unit)? = {
        Box(
            modifier = Modifier
                .size(30.dp, 4.dp)
                .background(Colors.WHITE, CircleShape)
        )
    },
    contentWindowInsets: @Composable () -> WindowInsets = {
        WindowInsets(
            16.dp,
            0.dp,
            16.dp,
            20.dp
        )
    },
    content: @Composable ColumnScope.() -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(tonalElevation, shape)
            .clip(shape)
            .background(containerColor, shape)
            .padding(contentWindowInsets().asPaddingValues())
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        dragHandle?.invoke()
        Spacer(Modifier.height(20.dp))
        content()
    }

}