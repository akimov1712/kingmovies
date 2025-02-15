package ru.topbun.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.topbun.ui.R
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Fonts
import ru.topbun.ui.theme.Typo
import ru.topbun.ui.utills.getScreenSize

sealed interface Cards {

    object VERTICAL{

        @Composable
        fun Card() {
            Column(
                modifier = Modifier.width(getScreenSize().width.times(0.4f))
            ) {
                ImagePreview()
                Spacer(Modifier.height(8.dp))
                TextPreview()
            }
        }

        @Composable
        private fun TextPreview() {
            AppText(
                text = "Уоллес и Громит: Самая дикая месть.",
                style = Typo.M,
                color = Colors.TEXT_100,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.height(4.dp))
            AppText(
                text = "2024",
                style = Typo.XS,
                color = Colors.TEXT_200,
            )
        }

        @Composable
        private fun ImagePreview() {
            Box {
                CardImage()
                PreviewTips()
            }
        }

        @Composable
        private fun PreviewTips() {
            Row(
                modifier = Modifier.padding(10.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Tips.RATING.Big(8.3f)
                Tips.QUALITY.Big("HD")
            }
        }

        @Composable
        private fun CardImage() {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.7f)
                    .clip(RoundedCornerShape(16.dp))
                    .drawWithContent {
                        drawContent()
                        drawRect(
                            Brush.verticalGradient(
                                listOf(
                                    Color.Black.copy(0f),
                                    Color.Black.copy(0.15f),
                                )
                            )
                        )
                    },
                painter = painterResource(R.drawable.vertical_card),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

    }

    object TOP{

        @Composable
        fun Card(position: Int) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                if(position < 10){
                    AppText(
                        text = position.toString(),
                        color = Colors.RED_200,
                        style = TextStyle.Default.copy(
                            fontSize = 180.sp,
                            fontFamily = Fonts.GOLOS,
                            fontWeight = FontWeight.SemiBold,
                            drawStyle = Stroke(
                                miter = 10f,
                                width = 10f,
                                join = StrokeJoin.Round
                            )
                        )
                    )
                }
                ImagePreview()
            }
        }

        @Composable
        private fun ImagePreview() {
            Box(
                modifier = Modifier.offset(x = -20.dp)
            ){
                CardImage()
                PreviewTips()
            }
        }

        @Composable
        private fun PreviewTips() {
            Row(
                modifier = Modifier.padding(10.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Tips.RATING.Big(8.3f)
                Tips.QUALITY.Big("HD")
            }
        }

        @Composable
        private fun CardImage() {
            Image(
                modifier = Modifier
                    .width(getScreenSize().width.times(0.4f))
                    .aspectRatio(0.7f)
                    .clip(RoundedCornerShape(16.dp))
                    .drawWithContent {
                        drawContent()
                        drawRect(
                            Brush.verticalGradient(
                                listOf(
                                    Color.Black.copy(0f),
                                    Color.Black.copy(0.15f),
                                )
                            )
                        )
                    },
                painter = painterResource(R.drawable.vertical_card),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

    }

    object HORIZONTAL{

        @Composable
        fun Card() {
            Box(
                Modifier.width(getScreenSize().width.times(0.85f))
            ){
                CardImage()
                PreviewTips()
                TextPreview()
            }
        }

        @Composable
        private fun BoxScope.TextPreview() {
            Column(
                modifier = Modifier.align(Alignment.BottomStart).padding(12.dp)
            ){
                AppText(
                    text = "Уоллес и Громит: Самая дикая месть.",
                    style = Typo.M,
                    color = Colors.TEXT_100,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(4.dp))
                AppText(
                    text = "2024",
                    style = Typo.XS,
                    color = Colors.TEXT_200,
                )
            }
        }

        @Composable
        private fun CardImage() {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.85f)
                    .clip(RoundedCornerShape(16.dp))
                    .drawWithContent {
                        drawContent()
                        drawRect(
                            Brush.verticalGradient(
                                listOf(
                                    Color.Black.copy(0f),
                                    Color.Black.copy(0.7f),
                                )
                            )
                        )
                    },
                painter = painterResource(R.drawable.horizontal_card),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        @Composable
        private fun BoxScope.PreviewTips() {
            Column(
                modifier = Modifier.align(Alignment.TopEnd).padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Tips.RATING.Big(8.3f)
                Tips.QUALITY.Big("HD")
            }
        }

    }

}