package ru.topbun.filter.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.topbun.ui.components.AppText
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo


@Composable
internal fun FilterItem(
    text: String,
    painter: Int,
    isSelectedItem: Boolean,
    isOpenList: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelectedItem) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(painter),
                contentDescription = null,
                tint = Colors.WHITE
            )
        }
        Box(
            Modifier
                .weight(1f)
                .defaultMinSize(minHeight = 24.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            AppText(
                text = text,
                color = Colors.TEXT_100,
                style = Typo.S,
            )
        }
        if (isSelectedItem) {
            val animateRotateArrow by animateFloatAsState(if (isOpenList) 180f else 0f)
            Icon(
                modifier = Modifier
                    .size(14.dp)
                    .rotate(animateRotateArrow),
                painter = painterResource(ru.topbun.ui.R.drawable.ic_arrow_down),
                contentDescription = null,
                tint = Colors.WHITE
            )
        }

    }
}