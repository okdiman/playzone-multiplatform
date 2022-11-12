package navigation

import NavigationTree
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import home.HomeScreen
import navigation.tabs.BaseTab
import navigation.tabs.BottomConfiguration
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import search.SearchScreen
import theme.Theme

fun RootComposeBuilder.mainFlow() {
    bottomNavigation(
        name = NavigationTree.Main.Dashboard.name,
        tabsNavModel = BottomConfiguration()
    ) {
        tab(BaseTab(NavigationTree.Main.Home.name)) {
            screen(NavigationTree.Main.Home.name) {
                HomeScreen()
            }
            screen(NavigationTree.Home.Profile.name) {
                Text(text = "Your profile", color = Theme.colors.secondaryTextColor)
            }
        }
        tab(BaseTab(NavigationTree.Main.Search.name)) {
            screen(NavigationTree.Main.Search.name) {
                SearchScreen()
            }
        }
        tab(BaseTab(NavigationTree.Main.Event.name)) {
            screen(NavigationTree.Main.Event.name) {

            }
        }
        tab(BaseTab(NavigationTree.Main.Videos.name)) {
            screen(NavigationTree.Main.Videos.name) {

            }
        }
    }
}