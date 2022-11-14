package admin.creategame

import admin.creategame.models.CreateGameAction
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun CreateGameScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { CreateGameViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()
        CreateGameView(state.value) { event ->
            viewModel.obtainEvent(event)
        }
        when (action.value) {
            is CreateGameAction.CloseScreen -> rootController.popBackStack()
            else -> {}
        }
    }
}