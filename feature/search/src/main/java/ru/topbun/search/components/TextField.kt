package ru.topbun.search.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.ImeAction
import ru.topbun.ui.components.AppTextField

@Composable
internal fun TextField(search: String, onTextChange: (String) -> Unit) {
    AppTextField(
        text = search,
        onTextChange = { onTextChange(it) },
        placeholder = "Название фильма",
        startIconRes = ru.topbun.ui.R.drawable.ic_search,
        onClickClear = { onTextChange("") },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
    )
}