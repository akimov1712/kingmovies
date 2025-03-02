package ru.topbun.filter.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.topbun.domain.entity.filter.SortType
import ru.topbun.filter.FilterItems
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.utills.rippleClickable


@Composable
internal fun ColumnScope.SortedList(
    filterItem: FilterItems,
) {
    val sortTypes = SortType.entries
    var selectedItem by remember { mutableStateOf<SortType?>(sortTypes.first()) }
    var isExpanded by remember { mutableStateOf(false) }
    val height = if (isExpanded) Modifier.weight(1f, false) else Modifier.wrapContentHeight()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
            .then(height)
            .clip(RoundedCornerShape(12.dp))
    ) {
        FilterItem(
            text = selectedItem.toString(),
            painter = filterItem.iconRes,
            modifier = Modifier
                .fillMaxWidth()
                .background(Colors.BG_300)
                .rippleClickable { isExpanded = !isExpanded }
                .padding(12.dp),
            isOpenList = isExpanded,
            isSelectedItem = true
        )

        if (isExpanded) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                val displayTypes = buildList<SortType?>{
                    sortTypes.filter { it != selectedItem }
                }
                itemsIndexed(displayTypes) { index, sortType ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(0.5.dp)
                            .background(Colors.BG_200)
                    )
                    FilterItem(
                        text = sortType.toString(),
                        painter = filterItem.iconRes,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Colors.BG_300)
                            .rippleClickable {
                                isExpanded = !isExpanded
                                selectedItem = sortType
                            }
                            .padding(12.dp),
                        isOpenList = isExpanded,
                        isSelectedItem = false
                    )

                }
            }
        }

    }
}
