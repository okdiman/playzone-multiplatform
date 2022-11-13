package navigation

import NavigationTree
import SplashScreen
import androidx.compose.material.Text
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import theme.Theme

fun RootComposeBuilder.generateGraph() {
    authFlow()
    mainFlow()
    screen(NavigationTree.Splash.SplashScreen.name) {
        SplashScreen()
    }
    screen(NavigationTree.Search.Game.name) {
        Text(text = "Game screen", color = Theme.colors.secondaryTextColor)
    }
}