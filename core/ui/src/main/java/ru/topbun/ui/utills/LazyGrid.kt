package ru.topbun.ui.utills

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun LazyGridState.isRowVisible(columnWidth: Dp, row: Int): State<Boolean> {
    val density = LocalDensity.current
    val screenSize = getScreenSize()
    val columnCount by remember {
        derivedStateOf {
            with(density) {
                (screenSize.width.toPx() / columnWidth.toPx()).toInt()
            }
        }
    }

    val isRowVisible = remember {
        derivedStateOf {
            val visibleItems = this.layoutInfo.visibleItemsInfo
            if (visibleItems.isEmpty()) return@derivedStateOf true
            val lastVisibleIndex = visibleItems.lastOrNull()?.index ?: 0
            lastVisibleIndex <= columnCount * row
        }
    }
    return isRowVisible
}