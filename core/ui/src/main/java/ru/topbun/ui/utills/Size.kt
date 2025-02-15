package ru.topbun.ui.utills

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@Composable
fun getScreenSize(): DpSize{
    val config = LocalConfiguration.current
    return DpSize(config.screenWidthDp.dp,config.screenHeightDp.dp)
}