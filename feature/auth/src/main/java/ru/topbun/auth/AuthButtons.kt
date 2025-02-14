package ru.topbun.auth

import androidx.compose.ui.graphics.Color
import ru.topbun.ui.R

enum class AuthButtons(
    val title: String,
    val color: Color,
    val iconRes: Int
) {

    YANDEX(
        title = "Яндекс",
        color = Color(0xFFFC3F1D),
        iconRes = R.drawable.ic_yandex
    ),

    VK(
        title = "ВК",
        color = Color(0xFF0077FF),
        iconRes = R.drawable.ic_vk
    ),

    TELEGRAM(
        title = "Telegram",
        color = Color(0xFF2AABEE),
        iconRes = R.drawable.ic_telegram
    ),

}