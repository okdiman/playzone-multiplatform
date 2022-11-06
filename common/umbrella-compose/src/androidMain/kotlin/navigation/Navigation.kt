package navigation

import NavigationTree
import SplashScreen
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.generateGraph() {
    authFlow()
    screen(NavigationTree.Splash.SplashScreen.name) {
        SplashScreen()
    }
}