package search

import NavigationTree
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import search.models.SearchAction

@Composable
fun SearchScreen() {
    val rootController = LocalRootController.current
    StoredViewModel(factory = { SearchViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()
        SearchView(state.value) { event ->
            viewModel.obtainEvent(event)
        }
        when (action.value) {
            is SearchAction.ShowGameDetail -> {
                rootController.findRootController().push(NavigationTree.Search.Game.name)
            }
            else -> {}
        }
    }
}