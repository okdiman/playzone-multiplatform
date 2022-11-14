package admin.creategame

import admin.creategame.models.CreateGameEvent
import admin.creategame.models.CreateGameViewState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import widgets.ActionButton
import widgets.CommonTextField

@Composable
fun CreateGameView(state: CreateGameViewState, eventHandler: (CreateGameEvent) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        CommonTextField(text = state.title, hint = "Game Title", enabled = !state.isSending) {
            eventHandler(CreateGameEvent.TitleChanged(it))
        }
        Spacer(Modifier.height(16.dp))
        CommonTextField(
            text = state.description,
            hint = "Game Description",
            enabled = !state.isSending
        ) {
            eventHandler(CreateGameEvent.DescriptionChanged(it))
        }
        Spacer(Modifier.height(16.dp))
        CommonTextField(text = state.version, hint = "Game Version", enabled = !state.isSending) {
            eventHandler(CreateGameEvent.VersionChanged(it))
        }
        Spacer(Modifier.height(16.dp))
        CommonTextField(text = state.size, hint = "Game Size", enabled = !state.isSending) {
            eventHandler(CreateGameEvent.SizeChanged(it))
        }
        Spacer(Modifier.height(16.dp))
        ActionButton(title = "Save changes", enabled = !state.isSending) {
            eventHandler(CreateGameEvent.SubmitCreation)
        }
    }
}