package ru.topbun.agreement

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.topbun.ui.R
import ru.topbun.ui.components.AppIconButton
import ru.topbun.ui.components.AppText
import ru.topbun.ui.components.TermsList
import ru.topbun.ui.components.ScreenWrapper
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo
import ru.topbun.ui.utills.koinViewModel

object AgreementScreen : Screen {

    @Composable
    override fun Content() {
        ScreenContent()
    }
}

@Preview(showBackground = true)
@Composable
private fun ScreenContent() = ScreenWrapper{
    val viewModel: AgreementViewModel = koinViewModel(LocalNavigator.currentOrThrow)
    val state by viewModel.collectAsState
    Header(viewModel)
    TermsList(state.agreementList)
}

@Composable
private fun Header(viewModel: AgreementViewModel) {
    Row(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppIconButton(R.drawable.ic_back) { viewModel.clickBack() }
        Column {
            AppText(
                "Пользовательское соглашение",
                style = Typo.L,
                color = Colors.TEXT_100,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            AppText("Редакция от 02.02.2025", style = Typo.XS, color = Colors.TEXT_200)
        }
    }
}




