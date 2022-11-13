package search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import search.models.SearchEvent
import search.models.SearchViewState
import theme.Theme
import widgets.CommonTextField

@Composable
fun SearchView(viewState: SearchViewState, eventHandler: (SearchEvent) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        CommonTextField(
            text = viewState.query,
            hint = "Search Game",
            onValueChanged = { eventHandler(SearchEvent.QueryChanged(it)) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            viewState.games.forEach { game ->
                item {
                    Text(
                        modifier = Modifier
                            .padding(
                                top = 8.dp,
                                bottom = 8.dp
                            )
                            .clickable {
                                eventHandler(SearchEvent.GameClicked)
                            },
                        text = game.title,
                        color = Theme.colors.secondaryTextColor,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}