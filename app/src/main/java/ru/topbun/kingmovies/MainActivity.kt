package ru.topbun.kingmovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.compose.getKoin
import ru.topbun.agreement.AgreementScreen
import ru.topbun.auth.AuthDialog
import ru.topbun.film.FilmScreen
import ru.topbun.main.MainScreen
import ru.topbun.privacy_policy.PrivacyScreen
import ru.topbun.splash.SplashScreen
import ru.topbun.ui.components.BottomSheetDialog
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.utills.changeStatusBar

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            changeStatusBar(Color.Transparent)
            BottomSheetNavigator(
                sheetShape = RoundedCornerShape(24.dp, 24.dp),
                sheetBackgroundColor = Colors.BG_200
            ){
                Navigator(FilmScreen)
            }
        }
    }

}

