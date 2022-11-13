package navigation.tabs

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabItem
import theme.Theme

class BottomNavigationTab(private val title: String) : TabItem() {
    override val configuration: TabConfiguration
        @Composable
        get() = TabConfiguration(
            title = title,
            selectedColor = Theme.colors.primaryAction,
            unselectedColor = Theme.colors.hintTextColor,
            titleStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        )
}