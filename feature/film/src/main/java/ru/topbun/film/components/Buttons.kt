package ru.topbun.film.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun Buttons() {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        ru.topbun.ui.components.Buttons.RED.Button(
            text = "Смотреть бесплатно",
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
        ) { }
        ru.topbun.ui.components.Buttons.OUTLINED.Button(
            modifier = Modifier.size(48.dp),
            painterRes = ru.topbun.ui.R.drawable.ic_favorite,
        ) { }
        ru.topbun.ui.components.Buttons.OUTLINED.Button(
            modifier = Modifier.size(48.dp),
            painterRes = ru.topbun.ui.R.drawable.ic_download,
        ) { }
    }
}