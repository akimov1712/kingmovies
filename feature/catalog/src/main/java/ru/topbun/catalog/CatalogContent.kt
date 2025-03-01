package ru.topbun.catalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import ru.topbun.catalog.components.GenreList
import ru.topbun.catalog.components.Title
import ru.topbun.navigation.SharedScreen
import ru.topbun.ui.components.FilmList
import ru.topbun.ui.theme.Colors
import ru.topbun.ui.utills.rippleClickable


object CatalogScreen: Screen {

    @Composable
    override fun Content() {
        ContentScreen()
    }
    
}

@Preview
@Composable
private fun ContentScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.BG_100)
            .systemBarsPadding(),
    ){
        val bottomSheetNavigator = LocalBottomSheetNavigator.current
        val filterScreen = rememberScreen(SharedScreen.FilterDialog)
        bottomSheetNavigator.show(filterScreen)
        Column{
            Title()
            Spacer(Modifier.height(20.dp))
            GenreList()
            Spacer(Modifier.height(10.dp))
            FilmList()
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
                .size(48.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Colors.RED_100_200)
                .rippleClickable {  },
            contentAlignment = Alignment.Center
        ){
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(ru.topbun.ui.R.drawable.ic_filter_filled),
                contentDescription = null,
                tint = Colors.WHITE
            )
        }
    }
}

