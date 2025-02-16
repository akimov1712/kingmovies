package ru.topbun.film

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import cafe.adriel.voyager.core.screen.Screen
import ru.topbun.film.components.Header
import ru.topbun.ui.components.AppIconButton
import ru.topbun.ui.components.AppText
import ru.topbun.ui.components.Buttons
import ru.topbun.ui.components.Tips
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo
import ru.topbun.ui.utills.koinViewModel
import ru.topbun.ui.utills.rippleClickable

object FilmScreen : Screen {

    @Composable
    override fun Content() {
        ScreenContent()
    }

}

@Preview
@Composable
private fun ScreenContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.BG_100)
    ) {
        val viewModel = koinViewModel<FilmViewModel>()
        AppIconButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .zIndex(2f)
                .padding(20.dp, 30.dp),
            painter = ru.topbun.ui.R.drawable.ic_back,
        ) {}
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ){
            Header()
            Info()
            Spacer(Modifier.height(20.dp))
            Buttons()
            Spacer(Modifier.height(20.dp))
            Description(viewModel)
        }
    }
}

@Composable
private fun Description(viewModel: FilmViewModel) {
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

@Composable
private fun Buttons() {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Buttons.RED.Button(
            text = "Смотреть бесплатно",
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
        ) { }
        Buttons.OUTLINED.Button(
            modifier = Modifier.size(48.dp),
            painterRes = ru.topbun.ui.R.drawable.ic_favorite,
        ) { }
        Buttons.OUTLINED.Button(
            modifier = Modifier.size(48.dp),
            painterRes = ru.topbun.ui.R.drawable.ic_download,
        ) { }
    }
}


@Composable
private fun Info() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        Tags()
        NameWithQuote()
    }
}

@Composable
private fun NameWithQuote() {
    AppText(
        text = "Фильм Уоллес и Громит: Самая дикая месть смотреть онлайн",
        style = Typo.L,
        color = Colors.TEXT_100,
    )
    AppText(
        text = "«Не трогай правоохранительные органы, они могут возбудить» — Стетхем Д.",
        style = Typo.S,
        color = Colors.TEXT_200,
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Tags() {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Tips.RATING.Big(8.4f)
        Tips.QUALITY.Big("HD")
        AppText("2025", style = Typo.S, color = Colors.TEXT_200, modifier = Modifier.align(Alignment.CenterVertically))
        AppText("Великобритания", style = Typo.S, color = Colors.TEXT_200, modifier = Modifier.align(Alignment.CenterVertically))
        AppText("Мультфильмы", style = Typo.S, color = Colors.TEXT_200, modifier = Modifier.align(Alignment.CenterVertically))
    }
}
