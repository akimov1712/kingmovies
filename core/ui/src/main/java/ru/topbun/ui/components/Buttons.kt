package ru.topbun.ui.components

import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo
import ru.topbun.ui.utills.rippleClickable

object Buttons {

    @Composable
    fun AppButton(
        text: String,
        modifier: Modifier = Modifier,
        shape: Shape = RoundedCornerShape(12.dp),
        backgroundColor: Brush = Colors.RED_100_200,
        onClick: () -> Unit,
    ) {
        Box(
            modifier = modifier
                .clip(shape)
                .background(backgroundColor)
                .rippleClickable {
                    onClick()
                },
            contentAlignment = Alignment.Center
        ){
            AppText(
                text = text,
                color = Colors.TEXT_100,
                style = Typo.M
            )
        }
    }


    object RED{

        @Composable
        fun Button(
            text: String,
            modifier: Modifier = Modifier,
            onClick: () -> Unit
        ) {
            AppButton(
                modifier = modifier,
                backgroundColor = Colors.RED_100_200,
                shape = RoundedCornerShape(12.dp),
                text = text
            ){
                onClick()
            }
        }

    }

    object TRANSPARENT{

        @Composable
        fun Button(
            text: String,
            modifier: Modifier = Modifier,
            onClick: () -> Unit
        ) {
            AppButton(
                modifier = modifier,
                backgroundColor = SolidColor(Colors.WHITE.copy(0.15f)),
                shape = RoundedCornerShape(12.dp),
                text = text
            ){
                onClick()
            }
        }

    }

}