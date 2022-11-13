package home

import NavigationTree
import android.util.Log
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import home.models.HomeAction
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun HomeScreen() {
    val rootController = LocalRootController.current
    StoredViewModel(factory = { HomeViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()
        HomeView(state.value) { event ->
            viewModel.obtainEvent(event)
        }

        when (action.value) {
            is HomeAction.ShowUserProfile -> {
                Log.e("TAG", "ShowUserProfile action")
                rootController.push(screen = NavigationTree.Home.Profile.name)
            }
            else -> {}
        }
    }
}