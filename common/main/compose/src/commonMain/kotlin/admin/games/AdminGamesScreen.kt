package admin.games

import NavigationTree
import admin.games.models.AdminGamesAction
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun AdminGamesScreen() {
    val rootController = LocalRootController.current
    StoredViewModel(factory = { AdminGamesViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()
        AdminGamesView(state.value) { event ->
            viewModel.obtainEvent(event)
        }
        when (action.value) {
            is AdminGamesAction.AddGamePressed -> {
                rootController.findRootController().present(NavigationTree.Admin.CreateGame.name)
            }
            else -> {}
        }
    }
}