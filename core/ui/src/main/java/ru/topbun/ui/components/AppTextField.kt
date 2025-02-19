package ru.topbun.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo
import ru.topbun.ui.utills.noRippleClickable

@Composable
fun AppTextField(
    text: String,
    onTextChange: (String) -> Unit,
    placeholder: String = "",
    padding: PaddingValues = PaddingValues(12.dp, 0.dp),
    startIconRes: Int? = null,
    onClickClear: (() -> Unit)? = null,

    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = Typo.S.copy(color = Colors.TEXT_100, fontWeight = FontWeight.Medium),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    interactionSource: MutableInteractionSource? = null,
    cursorBrush: Brush = SolidColor(Colors.TEXT_100),
    decorationBox: @Composable (innerTextField: @Composable () -> Unit) -> Unit =
        @Composable { innerTextField -> innerTextField() }
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(42.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Colors.BG_200)
            .padding(padding),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        startIconRes?.let {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(startIconRes),
                contentDescription = null,
                tint = Colors.TEXT_200
            )
        }
        Box(
            modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .align(Alignment.CenterVertically)
        ){
            if (text.isBlank()){
                AppText(
                    text = placeholder,
                    style = Typo.S.copy(fontWeight = FontWeight.Medium),
                    color = Colors.TEXT_200
                )
            }
            BasicTextField(
                value = text,
                onValueChange = onTextChange,
                textStyle = textStyle,
                cursorBrush = cursorBrush,
                enabled = enabled,
                readOnly = readOnly,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                singleLine = singleLine,
                maxLines = maxLines,
                minLines = minLines,
                visualTransformation = visualTransformation,
                onTextLayout = onTextLayout,
                interactionSource = interactionSource,
                decorationBox = decorationBox,
            )

        }
        if (onClickClear != null && text.isNotBlank()){
            Icon(
                modifier = Modifier
                    .size(16.dp)
                    .noRippleClickable { onClickClear() }
                    .padding(2.dp),
                painter = painterResource(ru.topbun.ui.R.drawable.ic_clear),
                contentDescription = null,
                tint = Colors.TEXT_200
            )
        }
    }
}

