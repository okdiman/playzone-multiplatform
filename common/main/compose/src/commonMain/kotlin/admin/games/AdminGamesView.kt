package admin.games

import admin.games.models.AdminGamesEvent
import admin.games.models.AdminGamesViewState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import theme.Theme

@Composable
fun AdminGamesView(viewState: AdminGamesViewState, eventHandler: (AdminGamesEvent) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Games list", fontSize = 28.sp, color = Theme.colors.secondaryTextColor)
            Spacer(Modifier.weight(1f))
            Icon(
                modifier = Modifier.clickable {
                    eventHandler(AdminGamesEvent.AddNewGame)
                },
                imageVector = Icons.Default.Add,
                contentDescription = "Add game",
                tint = Theme.colors.primaryAction
            )
        }
        Spacer(Modifier.height(16.dp))
        LazyColumn {
            viewState.games.forEach { game ->
                item {
                    Text(
                        modifier = Modifier
                            .padding(
                                top = 8.dp,
                                bottom = 8.dp
                            ),
                        text = game.title,
                        color = Theme.colors.secondaryTextColor,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        eventHandler(AdminGamesEvent.ViewInitialized)
    }
}