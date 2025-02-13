package ru.topbun.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


object Colors {

    val BG_100 = Color(0xFF1A1A1A)
    val BG_200 = Color(0xFF292929)
    val BG_300 = Color(0xFF404040)

    val TEXT_100 = Color(0xFFFFFFFF)
    val TEXT_200 = Color(0xFFA8A8A8)
    val TEXT_300 = Color(0xFF222222)

    val YELLOW_100 = Color(0xFFFFE34E)
    val YELLOW_200 = Color(0xFFE3C421)

    val RED_100 = Color(0xFFFF6347)
    val RED_200 = Color(0xFFD7341D)
    val RED_300 = Color(0xFF8D0000)
    val RED_100_200 = Brush.horizontalGradient(listOf(RED_100, RED_200))

    val GREEN_100 = Color(0xFF22F577)
    val GREEN_200 = Color(0xFF31CE70)

    val BLUE_100 = Color(0xFF2C32E0)
    val BLUE_200 = Color(0xFF474EFF)


}