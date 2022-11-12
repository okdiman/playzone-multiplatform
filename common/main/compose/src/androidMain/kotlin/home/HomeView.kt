package home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import home.models.HomeEvent
import home.models.HomeViewState
import theme.Theme

@Composable
fun HomeView(viewState: HomeViewState, eventHandler: (HomeEvent) -> Unit) {
    Row(
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 26.dp)
            .clickable {
                eventHandler(HomeEvent.UserProfileClicked)
            }
    ) {
        AsyncImage(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(28.dp)),
            model = viewState.avatarUrl,
            contentDescription = "avatar",
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.padding(start = 20.dp)) {
            Text(
                text = viewState.status,
                color = Theme.colors.secondaryTextColor.copy(alpha = 0.5f),
                fontSize = 14.sp
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = viewState.userName,
                color = Theme.colors.secondaryTextColor,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}