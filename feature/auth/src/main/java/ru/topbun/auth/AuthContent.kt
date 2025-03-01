package ru.topbun.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.topbun.navigation.SharedScreen
import ru.topbun.ui.components.AppText
import ru.topbun.ui.components.BottomSheetWrapper
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.theme.Typo
import ru.topbun.ui.utills.LinkText

object AuthDialog: Screen {

    @Composable
    override fun Content() {
        ScreenContent()
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenContent() {
    val navigator = LocalNavigator.currentOrThrow
    val agreementScreen = rememberScreen(SharedScreen.AgreementScreen)
    val privacyScreen = rememberScreen(SharedScreen.PrivacyScreen)
    BottomSheetWrapper{
        TextDialog()
        Spacer(Modifier.height(20.dp))
        ButtonsDialog()
        Spacer(Modifier.height(20.dp))
        AppText(
            text = buildAnnotatedString {
                append("Продолжая, я принимаю условия ")
                LinkText("Пользовательского соглашения"){ navigator.push(agreementScreen) }
                append(", ")
                LinkText("Политики конфиденциальности"){ navigator.push(privacyScreen) }
                append(" и ")
                LinkText("Оферты реферальной программы"){}
            },
            style = Typo.XS,
            color = Colors.TEXT_200,
        )
    }
}

@Composable
private fun ButtonsDialog() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val buttons = AuthButtons.entries.toList()
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            buttons.forEachIndexed { index, button ->
                if (index == buttons.size - 1){
                    AppText(
                        text = "Или",
                        style = Typo.M,
                        color = Colors.TEXT_200,
                    )
                }
                AuthButtonItem(button){}
            }
        }
    }
}

@Composable
private fun AuthButtonItem(button: AuthButtons, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(button.color),
        onClick = onClick
    ) {
        Image(
            painter = painterResource(button.iconRes),
            contentDescription = null,
        )
        Spacer(Modifier.width(8.dp))
        AppText(
            text = "Вход с помощью " + button.title,
            style = Typo.M,
            color = Colors.TEXT_100,
        )
    }
}

@Composable
private fun TextDialog() {
    AppText(
        text = "Добро пожаловать!",
        style = Typo.XL,
        color = Colors.TEXT_100,
        textAlign = TextAlign.Center
    )
    Spacer(Modifier.height(10.dp))
    AppText(
        text = "Для доступа к аккаунту воспользуйся одним из удобных способов входа.",
        style = Typo.M,
        color = Colors.TEXT_200,
        textAlign = TextAlign.Center
    )
}