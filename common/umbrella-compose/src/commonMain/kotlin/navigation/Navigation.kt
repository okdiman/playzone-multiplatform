package navigation

import NavigationTree
import SplashScreen
import admin.creategame.CreateGameScreen
import admin.navigation.adminFlow
import androidx.compose.material.Text
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import theme.Theme

enum class NavigationSource {
    Desktop, Android, IOS
}

fun RootComposeBuilder.generateGraph(source: NavigationSource) {
    screen(NavigationTree.Splash.SplashScreen.name) {
        SplashScreen()
    }
    screen(NavigationTree.Search.Game.name) {
        Text(text = "Game screen", color = Theme.colors.secondaryTextColor)
    }
    authFlow()
    when (source) {
        NavigationSource.Desktop -> {
            adminFlow()
            screen(NavigationTree.Admin.CreateGame.name) {
                CreateGameScreen()
            }
        }
        NavigationSource.Android -> mainFlow()
        NavigationSource.IOS -> {}
    }
}