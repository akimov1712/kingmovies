package ru.topbun.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import ru.topbun.ui.R
import ru.topbun.ui.utills.createFont

object Fonts {

    val GOLOS: FontFamily @Composable get() = FontFamily(
        Font(R.font.golos_bold, FontWeight.Bold),
        Font(R.font.golos_semibold, FontWeight.SemiBold),
        Font(R.font.golos_medium, FontWeight.Medium)
    )

}