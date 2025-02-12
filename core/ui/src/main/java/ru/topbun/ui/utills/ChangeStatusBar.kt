package ru.topbun.ui.utills

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun changeStatusBar(color: Color, darkIcons: Boolean = false) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = color,
        darkIcons = darkIcons
    )
}