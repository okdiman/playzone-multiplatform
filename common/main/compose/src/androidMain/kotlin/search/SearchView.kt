package search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import search.models.SearchEvent
import search.models.SearchViewState
import theme.Theme

@Composable
fun SearchView(viewState: SearchViewState, eventHandler: (SearchEvent) -> Unit) {
    Column {
        TextField(
            value = viewState.query,
            placeholder = {
                Text(
                    text = "Search Game",
                    color = Theme.colors.hintTextColor
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Theme.colors.secondaryBackground,
                textColor = Theme.colors.hintTextColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Theme.colors.highlightTextColor
            ),
            shape = Theme.shapes.default,
            onValueChange = { query ->
                eventHandler(SearchEvent.QueryChanged(query))
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(56.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            viewState.games.forEach { game ->
                item {
                    Text(
                        modifier = Modifier
                            .padding(
                                top = 8.dp,
                                bottom = 8.dp,
                                start = 16.dp,
                                end = 16.dp
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