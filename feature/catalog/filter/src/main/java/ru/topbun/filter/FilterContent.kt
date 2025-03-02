package ru.topbun.filter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import ru.topbun.filter.FilterItems.RATING
import ru.topbun.filter.FilterItems.SORTED
import ru.topbun.filter.FilterItems.YEAR
import ru.topbun.filter.components.FilterList
import ru.topbun.ui.components.BottomSheetWrapper
import ru.topbun.ui.components.Buttons
import ru.topbun.ui.utills.getScreenSize

object FilterDialog : Screen {

    @Composable
    override fun Content() {
        BottomSheetWrapper(
            modifier = Modifier.heightIn(max = getScreenSize().height / 1.5f)
        ) {
            val filterItems = FilterItems.entries
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    filterItems.forEach { filterItem ->
                        when (filterItem) {
                            SORTED -> { FilterList(filterItem) }
                            YEAR -> { FilterList(filterItem) }
                            RATING -> { FilterList(filterItem) }
                        }
                    }
                }
                Spacer(Modifier.height(10.dp))
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)){
                    Buttons.RED.Button(
                        text = "Применить",
                        modifier = Modifier.fillMaxWidth().height(48.dp)
                    ) { }
                    Buttons.TRANSPARENT.Button(
                        text = "Сбросить",
                        modifier = Modifier.fillMaxWidth().height(48.dp)
                    ) { }
                }

            }
        }
    }
}

