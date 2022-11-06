package navigation

import NavigationTree
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.adeo.kviewmodel.odyssey.setupWithViewModels
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.extensions.setupWithActivity
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator
import theme.AppTheme
import theme.Theme

fun ComponentActivity.setupThemedNavigation() {
    val rootController = RootComposeBuilder().apply { generateGraph() }.build().apply {
        setupWithActivity(this@setupThemedNavigation)
        setupWithViewModels()
    }
    setContent {
        AppTheme {
            rootController.backgroundColor = Theme.colors.primaryBackground
            CompositionLocalProvider(
                LocalRootController provides rootController
            ) {
                ModalNavigator {
                    Navigator(startScreen = NavigationTree.Splash.SplashScreen.name)
                }
            }
        }
    }
}