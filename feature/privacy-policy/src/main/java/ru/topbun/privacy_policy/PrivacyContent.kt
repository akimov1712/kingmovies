package ru.topbun.privacy_policy

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import ru.topbun.ui.components.ScreenWrapper

object PrivacyScreen: Screen {

    @Composable
    override fun Content() {
        ScreenContent()
    }
}

@Preview(showBackground = true)
@Composable
private fun ScreenContent() = ScreenWrapper{

}