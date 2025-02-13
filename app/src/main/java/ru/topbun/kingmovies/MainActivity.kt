package ru.topbun.kingmovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.defaultNavigatorSaver
import ru.topbun.splash.SplashScreen
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.utills.changeStatusBar

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            changeStatusBar(Color.Transparent)
            Navigator(SplashScreen)
        }
    }

}

