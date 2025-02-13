package ru.topbun.privacy_policy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import ru.topbun.domain.entity.privacy.PrivacyEntity
import ru.topbun.ui.R
import ru.topbun.ui.components.AppIconButton
import ru.topbun.ui.components.AppText
import ru.topbun.ui.components.ScreenWrapper
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo
import ru.topbun.ui.utills.koinViewModel

object PrivacyScreen : Screen {

    @Composable
    override fun Content() {
        ScreenContent()
    }
}

@Preview(showBackground = true)
@Composable
private fun ScreenContent() = ScreenWrapper{
    val viewModel: PrivacyViewModel = koinViewModel(LocalNavigator.currentOrThrow)
    val state by viewModel.collectAsState
    Header(viewModel)
    PrivacyList(state)
}

@Composable
private fun Header(viewModel: PrivacyViewModel) {
    Row(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppIconButton(R.drawable.ic_back) { viewModel.clickBack() }
        Column {
            AppText(
                "Политика конфиденциальности",
                style = Typo.L,
                color = Colors.TEXT_100,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            AppText("Редакция от 02.02.2025", style = Typo.XS, color = Colors.TEXT_200)
        }
    }
}

@Composable
private fun ColumnScope.PrivacyList(state: PrivacyState) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items = state.privacyList) {
            PrivacyItem(it)
        }
    }
}

@Composable
private fun PrivacyItem(privacy: PrivacyEntity) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AppText(privacy.title, style = Typo.M, color = Colors.TEXT_100)
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            privacy.points.forEach {
                AppText(
                    text = it,
                    style = Typo.S,
                    color = Colors.TEXT_200
                )
            }
        }
    }
}



