package ru.topbun.film.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.topbun.film.FilmViewModel
import ru.topbun.ui.components.AppText
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo
import ru.topbun.ui.utills.rippleClickable

@Composable
internal fun Description(viewModel: FilmViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        val state by viewModel.collectAsState
        AppText(
            text = "Описание",
            style = Typo.M,
            color = Colors.TEXT_100
        )
        Spacer(Modifier.height(8.dp))
        AppText(
            text = "«Уоллес и Громит: Самая дикая месть» (2024) — долгожданное возвращение любимых героев! Громит обеспокоен зависимостью Уоллеса от его изобретений, и его опасения подтверждаются, когда Уоллес создаёт «умного гнома», который начинает жить своей жизнью. Погрузитесь в мир уморительных приключений и изобретений! Узнайте, сможет ли  200. «Уоллес и Громит: Самая дикая месть» (2024) — долгожданное возвращение любимых героев! Громит обеспокоен зависимостью Уоллеса от его изобретений, и его опасения подтверждаются, когда Уоллес создаёт «умного гнома», который начинает жить своей жизнью. Погрузитесь в мир уморительных приключений и изобретений! Узнайте, сможет ли...",
            style = Typo.S,
            color = Colors.TEXT_200,
            maxLines = if (state.openDescription) Int.MAX_VALUE else 8,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(Modifier.height(4.dp))
        AppText(
            modifier = Modifier.rippleClickable { viewModel.switchOpenDescr() },
            text = if (state.openDescription) "Скрыть" else "Подробное описание",
            style = Typo.S,
            color = Colors.RED_100,
        )
    }
}