package ru.topbun.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.topbun.domain.entity.terms.TermsEntity
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo

@Composable
fun ColumnScope.TermsList(list: List<TermsEntity>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items = list) {
            TermsItem(it)
        }
    }
}

@Composable
private fun TermsItem(privacy: TermsEntity) {
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
