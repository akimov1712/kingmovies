package ru.topbun.ui.utills

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink

@Composable
fun AnnotatedString.Builder.LinkText(
    text: String,
    onClick: () -> Unit,
) {
    withLink(
        LinkAnnotation.Clickable(
            tag = text,
            styles = TextLinkStyles(
                SpanStyle(textDecoration = TextDecoration.Underline)
            ),
            linkInteractionListener = { onClick() }
        )
    ){
        append(text)
    }
}