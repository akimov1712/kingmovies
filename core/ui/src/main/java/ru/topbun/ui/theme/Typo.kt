package ru.topbun.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Typo {

    private val APP_STYLE @Composable get() = TextStyle(
        color = Colors.TEXT_300,
        fontFamily = Fonts.GOLOS,
    )

    val XL @Composable get() = APP_STYLE.copy(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
    )

    val L @Composable get() = APP_STYLE.copy(
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
    )

    val M @Composable get() = APP_STYLE.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
    )

    val S @Composable get() = APP_STYLE.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
    )

    val XS @Composable get() = APP_STYLE.copy(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
    )

    val XXS @Composable get() = APP_STYLE.copy(
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
    )

}