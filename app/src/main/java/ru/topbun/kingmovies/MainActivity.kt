package ru.topbun.kingmovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import ru.topbun.catalog.CatalogScreen
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.utills.changeStatusBar

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            changeStatusBar(Color.Transparent)
            BottomSheetNavigator(
                sheetShape = RoundedCornerShape(16.dp, 16.dp),
                sheetBackgroundColor = Colors.BG_200
            ){
                Navigator(CatalogScreen)
            }
        }
    }

}

