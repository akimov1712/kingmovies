package ru.topbun.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.G
import androidx.compose.ui.unit.dp
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo

sealed interface Tips {

    object QUALITY{

        @Composable
        fun Small(type: String){
            AppText(
                modifier = Modifier
                    .background(Colors.YELLOW_100_200, RoundedCornerShape(4.dp))
                    .padding(4.dp,2.dp),
                text = type,
                style = Typo.XXS,
                color = Colors.TEXT_300
            )
        }

        @Composable
        fun Big(type: String){
            AppText(
                modifier = Modifier
                    .background(Colors.YELLOW_100_200, RoundedCornerShape(6.dp))
                    .padding(6.dp, 3.5.dp),
                text = type,
                style = Typo.S,
                color = Colors.TEXT_300
            )
        }
    }

    object RATING{

        private fun getColor(rating: Float): Brush{
            return when{
                rating >= 8f -> Colors.RED_100_200
                rating >= 5f -> Colors.GREEN_100_200
                else -> Colors.BLUE_100_200
            }
        }

        @Composable
        fun Small(rating: Float){
            AppText(
                modifier = Modifier
                    .background(getColor(rating), RoundedCornerShape(4.dp))
                    .padding(4.dp,2.dp),
                text = rating.toString(),
                style = Typo.XXS,
                color = Colors.TEXT_100
            )
        }

        @Composable
        fun Big(rating: Float){
            AppText(
                modifier = Modifier
                    .background(getColor(rating), RoundedCornerShape(6.dp))
                    .padding(6.dp, 3.5.dp),
                text = rating.toString(),
                style = Typo.S,
                color = Colors.TEXT_100
            )
        }

    }

}