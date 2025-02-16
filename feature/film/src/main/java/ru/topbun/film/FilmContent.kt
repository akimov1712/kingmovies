package ru.topbun.film

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import cafe.adriel.voyager.core.screen.Screen
import ru.topbun.film.components.ActorList
import ru.topbun.film.components.Buttons
import ru.topbun.film.components.Description
import ru.topbun.film.components.Header
import ru.topbun.film.components.Info
import ru.topbun.film.components.ResemblingList
import ru.topbun.ui.components.AppIconButton
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.utills.koinViewModel

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
                .padding(20.dp, 50.dp),
            painter = ru.topbun.ui.R.drawable.ic_back,
        ) {}
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
                .navigationBarsPadding()
                .padding(bottom = 20.dp)
        ){
            Header()
            Info()
            Spacer(Modifier.height(20.dp))
            Buttons()
            Spacer(Modifier.height(20.dp))
            Description(viewModel)
            Spacer(Modifier.height(20.dp))
            ActorList()
            Spacer(Modifier.height(20.dp))
            ResemblingList()
        }
    }
}

