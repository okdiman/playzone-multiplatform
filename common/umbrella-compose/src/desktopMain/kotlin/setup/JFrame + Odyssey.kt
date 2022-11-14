package setup

import NavigationTree
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.awt.ComposePanel
import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.WindowConstants
import navigation.NavigationSource
import navigation.generateGraph
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator
import theme.AppTheme
import theme.Theme

fun JFrame.setupThemedNavigation() {
    val rootController = RootComposeBuilder().apply {
        generateGraph(NavigationSource.Desktop)
    }.build()

    defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    title = "Playzone admin"

    val composePanel = ComposePanel().apply {
        setContent {
            CompositionLocalProvider(
                LocalRootController provides rootController
            ) {
                AppTheme {
                    rootController.backgroundColor = Theme.colors.primaryBackground

                    /**
                     * ModalNavigator почему то не работает
                     */
//                    ModalNavigator {
                        Navigator(startScreen = NavigationTree.Splash.SplashScreen.name)
//                    }
                }
            }
        }
    }

    /**
     * добавляем нашу панель
     */
    contentPane.add(composePanel, BorderLayout.CENTER)
    setSize(800, 600)
    /**
     * убираем привязку
     */
    setLocationRelativeTo(null)
    isVisible = true
}