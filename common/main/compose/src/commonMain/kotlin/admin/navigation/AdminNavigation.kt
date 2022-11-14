package admin.navigation

import NavigationTree
import admin.events.AdminEventsScreen
import admin.games.AdminGamesScreen
import navigation.tabs.BottomConfiguration
import navigation.tabs.BottomNavigationTab
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.adminFlow() {
    bottomNavigation(
        name = NavigationTree.Admin.Dashboard.name,
        tabsNavModel = BottomConfiguration()
    ) {
        tab(BottomNavigationTab(NavigationTree.Admin.Games.name)) {
            screen(NavigationTree.Admin.Games.name) {
                AdminGamesScreen()
            }
        }
        tab(BottomNavigationTab(NavigationTree.Admin.Events.name)) {
            screen(NavigationTree.Admin.Events.name) {
                AdminEventsScreen()
            }
        }
    }
}